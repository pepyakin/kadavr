package org.knott.kadavr;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class MethodFormatter extends CodeFormatter {

    private AccessFlagsParser parser;
    
    public MethodFormatter(
            IdentTextWriter writer,
            AccessFlagsParser parser) {
        super(writer);
        
        if (parser == null) {
            throw new NullPointerException();
        }
        
        this.parser = parser;
    }
    
    public MethodFormatter(
            IdentTextWriter writer) {
        this(writer, AccessFlagsParser.PARSER_METHOD);
    }
    
    /**
     * Начать декларацию метода.
     * @param accessFlags
     * @param descriptor 
     */
    public void beginMethod(int accessFlags, String name, String descriptor) 
            throws IOException {
        writeDirective(".method");
        whitespace();
        writeDirective(parser.format(accessFlags));
        whitespace();
        writeIdentifier(name);
        writeIdentifier(descriptor);
        newline();
        pushIdent();
        setIdentLevel(1);
    }
    
    public void endMethod() 
            throws IOException {
        popIdent();
        writeDirective(".end method");
        newline();
        newline();
    }
}
