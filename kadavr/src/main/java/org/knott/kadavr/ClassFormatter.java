package org.knott.kadavr;

import java.io.IOException;
import org.omg.PortableServer.IdAssignmentPolicy;

/**
 *
 * @author Sergey
 */
public class ClassFormatter extends CodeFormatter {

    private AccessFlagsParser parser;
    
    public ClassFormatter(
            IdentTextWriter writer, 
            AccessFlagsParser parser) {
        super(writer);
        if (parser == null) {
            throw new NullPointerException();
        }
        
        this.parser = parser;
    }
    
    public ClassFormatter(IdentTextWriter writer) {    
        this(writer, AccessFlagsParser.PARSER_CLASS);
    }
    
    /**
     * Declare .source id.
     */
    public void writeSource(String fileName)
            throws IOException {
        writeDirective(".source");
        whitespace();
        writeIdentifier(fileName);
        newline();
    }
    
    public void writeClass(int accFlags, String className) 
            throws IOException {
        writeDirective(".class");
        whitespace();
        writeDirective(parser.format(accFlags));
        whitespace();
        writeIdentifier(className);
        newline();
    }
    
    public void writeSuper(String superClass) 
            throws IOException {
        writeDirective(".class");
        whitespace();
        writeIdentifier(superClass);
        newline();
    }
    
    public void writeImplements(String iface) 
            throws IOException {
        writeDirective(".implements");
        whitespace();
        writeIdentifier(iface);
        newline();
    }
}
