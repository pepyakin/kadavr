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
}
