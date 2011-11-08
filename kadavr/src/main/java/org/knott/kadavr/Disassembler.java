package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFile;
import org.knott.kadavr.metadata.Method;

/**
 * Класс заботится о высоком уровне дизассембирования
 * кода.
 * @author Sergey
 */
public class Disassembler {
    
    IdentTextWriter writer;
    ClassFile classFile;
    
    public Disassembler(IdentTextWriter writer, ClassFile classFile) {
        this.writer = writer;
        this.classFile = classFile;
    }
    
    public void disassemble() throws IOException {
        ClassDisasm clDisasm;
    
        clDisasm = new ClassDisasm(writer);
        clDisasm.setClassFile(classFile);
        
        clDisasm.parse();
        
        for (Method method : classFile.getMethods()) {
            MethodDisasm methodDisasm = new MethodDisasm(writer, method);
            methodDisasm.beginParse();
            
            BytecodeDisasm bcDisasm = new BytecodeDisasm(writer, method.getCode(), classFile);
            bcDisasm.parse();
            
            methodDisasm.endParse();
        }
    }
}
