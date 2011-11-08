# Script for converting opcode list to
# java enum.
# (Gathered from "Opcode Mnemonics by Opcode" Appendix,
# http://java.sun.com/docs/books/jvms/second_edition/html/Mnemonics.doc.html )
#
# Shulepov Sergey

import os

def findMnemonic(line):
	"""Parses specified line and returns mnemonic of operation."""
	mIdx = line.rfind(' ')
	if mIdx == -1:
		return ""
	
	mnemonic = line[mIdx + 1:]
	return mnemonic.strip()
	
def findOpcode(line):
	"""Parses specified line and returns operation code."""
	splitted = line.split()
	return int(splitted[0])
	
def findSize(line):
	splitted = line.split()
	return int(splitted[2])

# Open file to read.
opcodeFile = open('opcodes.txt', 'r')
genFile = open('Opcode.java', 'w')
bcVisit = open('BytecodeVisitor.java', 'w')
bcParser = open('BytecodeParser.java', 'w')

autogenHeader = """/**
 * AUTO-GENERATED FILE. DO NOT EDIT.
 */""";

genFile.write(autogenHeader + """
 
package org.knott.kadavr.tools;
 
public enum Opcode {
""")

bcVisit.write(autogenHeader + """
package org.knott.kadavr.tools;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;

public abstract class BytecodeVisitor {

public void preVisit(Opcode opcode) throws IOException {}
public void postVisit(Opcode opcode) throws IOException {}
""")

bcParser.write(autogenHeader + """
package org.knott.kadavr.tools;

import java.io.*;
import org.knott.kadavr.metadata.ClassFileReader;

public class BytecodeParser {

private BytecodeVisitor visitor;
private ClassFileReader reader;

public BytecodeParser(BytecodeVisitor visitor, ClassFileReader reader) {
this.visitor = visitor;
this.reader = reader;
}

public void parse() throws IOException {
   try {
   while (true) {
            int opcodeValue = reader.readU1();
            Opcode opcode = Opcode.getOpcode(opcodeValue);
            visitor.preVisit(opcode);
			byte[] operandData = new byte[opcode.opSize];
            reader.read(operandData);
            
            ClassFileReader isolated = new ClassFileReader(new ByteArrayInputStream(operandData));
            switch (opcode) {

""")

first = True

# Process all lines in file.
for line in opcodeFile:
	if first:
		first = False
	else:
		genFile.write(',\n')

	
	
	mnemonic = findMnemonic(line)
	opcode = findOpcode(line)
	opSize = findSize(line)
	enumName = mnemonic.upper()
	
	genFile.write(enumName)
	genFile.write('(')
	genFile.write(str(opcode))
	genFile.write(',"')
	genFile.write(mnemonic)
	genFile.write('",')
	genFile.write(str(opSize))
	genFile.write(')')
	
	methodName = mnemonic
	methodName = "visit" + methodName[0].upper() + methodName[1:]
	
	bcVisit.write("""
public void %s(ClassFileReader r) throws IOException{}
	""" % methodName)
	
	bcParser.write("""
	case %s: visitor.%s(isolated);
	""" % (enumName, methodName))


genFile.write(';')

genFile.write("""

public final int opcode;
public final String mnemonic;
public final int opSize;

private Opcode(int opcode, String mnemonic, int opSize) {
this.opcode = opcode;
this.mnemonic = mnemonic;
this.opSize = opSize;
}

public static Opcode getOpcode(int opcodeValue) {
    for (Opcode opcode : values()) {
        if (opcode.ordinal() == opcodeValue) {
            return opcode;
        }
    }
    
    return null;
}
}
""");

bcVisit.write("""
}""")

bcParser.write("""
                
            }
			visitor.postVisit(opcode);
        }
	} catch (EOFException e) {
	  return;
	}
}
}
""")