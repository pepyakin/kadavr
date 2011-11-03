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

# Open file to read.
opcodeFile = open('opcodes.txt', 'r')
genFile = open('Opcode.java', 'w')

genFile.write("""/**
 * AUTO-GENERATED FILE. DO NOT EDIT.
 */
 
package org.knott.kadavr;
 
public enum Opcode {
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
	
	genFile.write(mnemonic.upper())
	genFile.write('(')
	genFile.write(str(opcode))
	genFile.write(',"')
	genFile.write(mnemonic)
	genFile.write('")')

genFile.write(';')

genFile.write("""

public final int opcode;
public final String mnemonic;

private Opcode(int opcode, String mnemonic) {
this.opcode = opcode;
this.mnemonic = mnemonic;
}
}
""");