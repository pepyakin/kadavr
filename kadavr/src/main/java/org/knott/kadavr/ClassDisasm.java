package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFile;
import org.knott.kadavr.metadata.attr.Attributes;
import org.knott.kadavr.metadata.attr.SourceFile;

/**
 *
 * @author Sergey
 */
public class ClassDisasm {
    
    private ClassFormatter formatter;
    private ClassFile classFile;

    /**
     * Создать экземпляр класса {@link ClassDisasm}.
     * @param formatter
     * @param classFile 
     */
    public ClassDisasm(ClassFormatter formatter, ClassFile classFile) {
        if (formatter == null) {
            throw new NullPointerException();
        }
        
        if (classFile == null) {
            throw new NullPointerException();
        }
        
        this.formatter = formatter;
        this.classFile = classFile;
    }

    public ClassFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(ClassFormatter formatter) {
        this.formatter = formatter;
    }
    
    public void parse() throws IOException {
        Attributes attrs = classFile.getAttributes();
        
        SourceFile source = (SourceFile)attrs.get(SourceFile.NAME);
        if (source != null) {
            // Иначе, желательно добавить 
            // .source outputfile.J
            formatter.writeSource(source.getName());
        }
        
        formatter.writeClass(classFile.getAccessFlags(), classFile.getName());
       
        String superName = classFile.getSuperName();
        formatter.writeSuper(superName);
    }
}
