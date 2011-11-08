/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import org.knott.kadavr.metadata.ClassFile;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.attr.Code;
import org.knott.kadavr.tools.BytecodeParser;
import org.knott.kadavr.tools.BytecodeVisitor;
import org.knott.kadavr.tools.Opcode;

/**
 *
 * @author knott
 */
public class BytecodeDisasm extends BytecodeVisitor {
    
    private BytecodeFormatter formatter;
    private ClassFileReader reader;
    
    private Code code;
    private ClassFile cf;
    
    private BytecodeParser parser;

    public BytecodeDisasm(IdentTextWriter writer, Code code, ClassFile cf) {
        this(new BytecodeFormatter(writer), code, cf);
    }
    
    /**
     * Создать экземпляр дизассемблера байт кода.
     * @param formatter
     * @param code 
     */
    public BytecodeDisasm(BytecodeFormatter formatter, Code code, ClassFile cf) {
        this.formatter = formatter;
        this.code = code;
        this.cf = cf;
        
        // Создать считыватель кода на основе 
        // данных из массива.
        this.reader = new ClassFileReader(
                new ByteArrayInputStream(code.getCode()));
        
        parser = new BytecodeParser(this, reader);
    }
    
    /**
     * Выполнить разбор кода.
     * @throws IOException 
     */
    public void parse() throws IOException {
        formatter.writeLimitLocals(code.getMaxLocals());
        formatter.writeLimitStack(code.getMaxStack());
        
        formatter.newline();
        
        parser = new BytecodeParser(this, reader);
        parser.parse();
    }
    
    @Override
    public void preVisit(Opcode opcode) throws IOException {
        formatter.writeInstruction(opcode.mnemonic);
    }

    @Override
    public void postVisit(Opcode opcode) throws IOException {
        formatter.newline();
    }
}
