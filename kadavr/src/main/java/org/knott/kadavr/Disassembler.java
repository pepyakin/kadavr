package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFile;
import org.knott.kadavr.metadata.Field;
import org.knott.kadavr.metadata.Method;

/**
 * Класс заботится о высоком уровне дизассембирования
 * кода.
 * @author Sergey
 */
public class Disassembler {

    IdentTextWriter writer;
    ClassFile classFile;

    /**
     * Создать экземпляр дизассемблера.
     * @param writer Поток символов для вывода.
     * @param classFile Класс который будет разобран.
     */
    public Disassembler(IdentTextWriter writer, ClassFile classFile) {
        this.writer = writer;
        this.classFile = classFile;
    }

    /**
     * Разобрать и вывести в указанный {@link IdentTextWriter}.
     * @throws IOException Возникает при неудачном выводе
     * в райтер.
     */
    public void disassemble() throws IOException {
        disassembleClass();
        disassembleFields();
        disassembleMethods();
    }

    private void disassembleMethods() throws IOException {
        for (Method method : classFile.getMethods()) {
            MethodDisasm methodDisasm = new MethodDisasm(writer, method);
            methodDisasm.beginParse();

            if (method.haveBody()) {
                BytecodeDisasm bcDisasm = new BytecodeDisasm(writer, method.getCode(), classFile);
                bcDisasm.parse();
            }

            methodDisasm.endParse();
        }
    }

    private void disassembleClass() throws IOException {
        ClassDisasm clDisasm;

        clDisasm = new ClassDisasm(writer);
        clDisasm.setClassFile(classFile);

        clDisasm.parse();
    }

    private void disassembleFields() throws IOException {
        for (Field field : classFile.getFields()) {
            FieldDisasm fieldDisasm = new FieldDisasm(writer, field);
            fieldDisasm.parse();
        }
    }
}
