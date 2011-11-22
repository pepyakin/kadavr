package org.knott.kadavr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import org.knott.kadavr.metadata.ClassFile;

/**
 * Точка входа в приложение. Главный класс.
 * 
 * @author Sergey
 */
public class App implements Serializable {

    private static final String PREFIX = "target/classes/";

    public static void main(String[] args) {
        String input, output;

        switch (args.length) {
            case 1:
                input = args[0];
                output = null;
                break;

            case 2:
                input = args[0];
                output = args[1];
                break;

            default:
                System.out.println("Usage: input_file.class out.J");
                System.exit(-2);
                return;

        }

//        input = PREFIX + "org/knott/kadavr/tools/BytecodeParser.class";
//        output = null;

        if (!exists(input)) {
            System.out.print(input);
            System.out.println(" doesnt exists");
            System.exit(-3);
        }

        try {
            disasm(input, output);
        } catch (IOException ex) {
            System.out.println("IO Error");
            System.exit(-4);
        }

        System.exit(0);
    }

    private static void disasm(String input, String output)
            throws IOException {

        OutputStream out = output == null ?
                System.out : new FileOutputStream(output);

        IdentTextWriter writer = new IdentTextWriter(
                new OutputStreamWriter(out));

        ClassFile c  = ClassFile.fromFile(input);
        Disassembler dis = new Disassembler(writer, c);

        dis.disassemble();
        writer.flush();
    }

    private static boolean exists(String input) {
        return new File(input).exists();
    }

    private void test1() {
        for (int i = 0; i < 150; i++) {
            System.out.println(-128);
        }
    }
}
