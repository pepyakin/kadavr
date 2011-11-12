package org.knott.kadavr;

import java.io.IOException;

/**
 * Форматировщик для вывода байткода.
 * @author Sergey
 */
public class BytecodeFormatter
        extends CodeFormatter {
    
    private LabelGen labelGen;

    public BytecodeFormatter(IdentTextWriter writer, LabelGen labelGen) {
        super(writer);
        
        if (labelGen == null) {
            throw new NullPointerException();
        }
        
        this.labelGen = labelGen;
    }
    
    public BytecodeFormatter(IdentTextWriter writer) {
        this(writer, new LabelGen());
    }
    
    public void writeLabelDecl(int pc) 
            throws IOException {
        writeLabel(labelGen.genLabelName(pc) + ":");
        whitespace();
    }
    
    public void writeLabel(int pc) throws IOException {
        writeLabel(labelGen.genLabelName(pc));
        whitespace();
    }
    
    public void writeLimitStack(int limit) throws IOException {
        writeDirective(".limit");
        whitespace();
        writeDirective("stack");
        whitespace();
        writeIntermediate(limit);
        newline();
    }
    
    public void writeLimitLocals(int limit) throws IOException {
        writeDirective(".limit");
        whitespace();
        writeDirective("locals");
        whitespace();
        writeIntermediate(limit);
        newline();
    }

    public void writeOperand(String valueString) throws IOException {
        write(valueString);
    }
}
