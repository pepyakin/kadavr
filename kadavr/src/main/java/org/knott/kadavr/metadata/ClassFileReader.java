/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Утилиты, которые могут быть полезны при 
 * считывании файлов класса Java.
 * @author Sergey
 */
public class ClassFileReader extends DataInputStream {

    public ClassFileReader(InputStream in) {
        super(in);
    }
    
    public int readU1() throws IOException {
        return readUnsignedByte();
    }
        
    public int readU2() throws IOException {
        return readUnsignedShort();
    }
    
    public long readU4() throws IOException {
        return readInt() & 0xFFFFFFFF;
    }
}
