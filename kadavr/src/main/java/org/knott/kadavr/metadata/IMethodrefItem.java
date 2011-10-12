package org.knott.kadavr.metadata;

/**
 *
 * @author Sergey
 */
public class IMethodrefItem extends MemberItem {
    
    public static final int TAG = ConstPool.TAG_INTERFACEMETHODREF;

    public IMethodrefItem() {
        super(TAG);
    }
    
    static class IMethodrefReader extends RefReader<IMethodrefItem> {

        public IMethodrefReader() {
            super(TAG);
        }
        
        @Override
        protected IMethodrefItem getDummy() {
            return new IMethodrefItem();
        }
    }
}
