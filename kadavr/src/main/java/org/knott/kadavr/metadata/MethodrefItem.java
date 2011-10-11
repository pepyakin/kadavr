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
    
    static class MethodrefReader extends RefReader<MethodrefItem> {

        public MethodrefReader() {
            super(TAG);
        }
        
        @Override
        protected MethodrefItem getDummy() {
            return new MethodrefItem();
        }
    }
}
