package org.knott.kadavr;

import java.util.Comparator;

/**
 *
 * @author Sergey
 */
public enum AccessFlag {
    PUBLIC(0x0001, "public", 0),
    PRIVATE(0x0002, "private", 0),
    PROTECTED(0x0004, "protected", 0),
    STATIC(0x0008, "static", 2),
    FINAL(0x0010, "final", 1),
    SYNCHRONIZED(0x0010, "synchronized", 3),
    SUPER(0x0020, "super", 1),
    VOLATILE(0x0040, "volatile", 4),
    TRANSIENT(0x0080, "transient", 4),
    NATIVE(0x0100, "native", 3),
    INTERFACE(0x0200, "interface", 5),
    ABSTRACT(0x0400, "abstract", 1),
    STRICT(0x0800, "strictfp", 5);
    
    private final int flag;
    private final String mnemonic;
    private final int priority;

    private AccessFlag(int flag, String mnemonic, int priority) {
        this.flag = flag;
        this.mnemonic = mnemonic;
        this.priority = priority;
    }

    public int getFlag() {
        return flag;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public int getPriority() {
        return priority;
    }
    
    public boolean isSet(int flags) {
        return ((flag & flags) != 0);
    }
}
