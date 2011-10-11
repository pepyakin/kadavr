package org.knott.kadavr.metadata;

/**
 * @author Sergey
 */
public class FieldrefItem extends MemberItem {

    public static final int TAG = ConstPool.TAG_FIELDREF;

    public FieldrefItem() {
        super(TAG);
    }
    
    class FieldrefReader extends RefReader<FieldrefItem> {

        public FieldrefReader() {
            super(TAG);
        }

        @Override
        protected FieldrefItem getDummy() {
            return new FieldrefItem();
        }
    }
}
