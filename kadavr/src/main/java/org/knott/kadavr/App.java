package org.knott.kadavr;

import org.knott.kadavr.metadata.ClassFile;

/**
 *
 * @author Sergey
 */
public class App {
    
    private static final String PREFIX = "target/classes/";
    
    public static void main(String[] args) throws Exception {
        String curDir = System.getProperty("user.dir");
        
        System.out.println(curDir);
        //ClassFile c = ClassFile.fromFile(PREFIX + "org/knott/kadavr/metadata/ClassFile.class");
        ClassFile c = ClassFile.fromFile(PREFIX + "org/knott/kadavr/App.class");
        
        System.out.println("hello");
    }
}
