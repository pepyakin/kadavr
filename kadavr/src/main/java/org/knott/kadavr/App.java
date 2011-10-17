package org.knott.kadavr;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.knott.kadavr.metadata.ClassFile;

/**
 *
 * @author Sergey
 */
public class App {
    
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
        
        ClassFile c = ClassFile.fromFile(PREFIX + "org/knott/kadavr/App.class");
        
        ClassDisasm disasm = new ClassDisasm(new ClassFormatter(writer), c);
        disasm.parse();
        writer.flush();
    }
}
