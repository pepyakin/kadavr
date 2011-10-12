package org.knott.kadavr.metadata;

/**
 *
 * @author Sergey
 */
public class MethodrefItem extends MemberItem {

    public static final int TAG = ConstPool.TAG_METHODREF;
    
    public MethodrefItem() {
        super(TAG);
    }
}
