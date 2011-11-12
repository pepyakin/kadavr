/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr.metadata;

/**
 *
 * @author knott
 */
public enum AType {
    
    BOOLEAN(4, "boolean"),
    CHAR(5, "char"),
    FLOAT(6, "float"),
    DOUBLE(7, "double"),
    BYTE(8, "byte"),
    SHORT(9, "short"),
    INT(10, "int"),
    LONG(11, "long");
    
    private final int acode;
    private final String mnemonic;

    public String getMnemonic() {
        return mnemonic;
    }

    private AType(int acode, String mnemonic) {
        this.acode = acode;
        this.mnemonic = mnemonic;
    }
    
    public static AType byACode(int acode) {
        for (AType atype : values()) {
            if (atype.acode == acode) {
                return atype;
            }
        }
        
        return null;
    }
}
