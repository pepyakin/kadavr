package org.knott.kadavr;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import org.knott.kadavr.metadata.ClassFile;
import org.knott.kadavr.tools.Opcode;

/**
 *
 * @author Sergey
 */
public class App implements Serializable {
    
    private static final String PREFIX = "target/classes/";
    
    public static void main(String[] args) throws Exception {
//        String curDir = System.getProperty("user.dir");
//        
//        System.out.println(curDir);
//        //ClassFile c = ClassFile.fromFile(PREFIX + "org/knott/kadavr/metadata/ClassFile.class");

//        
//        System.out.println("hello");
        
        IdentTextWriter writer = new IdentTextWriter(
                new OutputStreamWriter(System.out));
        
        ClassFile c = ClassFile.fromFile(
                PREFIX + "org/knott/kadavr/App.class");
        
        Disassembler dis = new Disassembler(writer, c);
        dis.disassemble();
        writer.flush();
    }
    
    private void test1() {
        for (int i = 0; i < 150; i++) {
            System.out.println(-128);
        }
    }
}
