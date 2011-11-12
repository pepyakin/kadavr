/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import java.io.IOException;

/**
 *
 * @author knott
 */
public class FieldFormatter extends CodeFormatter {
    
    private AccessFlagsParser parser;

    public FieldFormatter(AccessFlagsParser parser, IdentTextWriter writer) {
        super(writer);
        this.parser = parser;
    }
    
    public FieldFormatter(IdentTextWriter writer) {
        this(AccessFlagsParser.PARSER_FIELD, writer);
    }
    
    public void writeField(int accessFlags, String name, String desc, String value) 
            throws IOException {
        writeDirective(".field");
        whitespace();
        writeDirective(parser.format(accessFlags));
        whitespace();
        writeIdentifier(name);
        whitespace();
        writeIdentifier(desc);
        if (value != null) {
            write(" = ");
            writeIdentifier(value);
        }
        newline();
        newline();
    }
    
    public void writeField(int accessFlags, String name, String desc) throws IOException {
        writeField(accessFlags, name, desc, null);
    }
}
