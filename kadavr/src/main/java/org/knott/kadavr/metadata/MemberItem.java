package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public abstract class MemberItem extends ConstItem {

    int ownerClassIndex;
    int nameTypeIndex;
    private ClassItem owner;
    private NameTypeItem nameType;
    
    private int tag;
    
    protected MemberItem(int tag) {
        this.tag = tag;
    }

    public NameTypeItem getNameType() {
        return nameType;
    }

    public ClassItem getOwner() {
        return owner;
    }

    @Override
    void link(ConstPool pool) {
        owner = pool.getClass(ownerClassIndex);
        nameType = pool.getNameAndType(nameTypeIndex);
    }

    @Override
    public int getTag() {
        return tag;
    }

    protected abstract static class RefReader<T extends MemberItem> extends Reader<T> {
        
        private int tag;

        public RefReader(int tag) {
            this.tag = tag;
        }
        
        /**
         * Создать пустой класс для его заполнения.
         * @return 
         */
        protected abstract T getDummy();

        @Override
        protected final T readItem(ClassFileReader dis)
                throws IOException {
            T item = getDummy();
            if (item == null) {
                throw new NullPointerException("getDummy() shouldn't return null.");
            }

//        CONSTANT_Fieldref_info {
//            u1 tag;
//            u2 class_index;
//            u2 name_and_type_index;
//        }
//
//
//        CONSTANT_Methodref_info {
//            u1 tag;
//            u2 class_index;
//            u2 name_and_type_index;
//        }
//
//
//        CONSTANT_InterfaceMethodref_info {
//            u1 tag;
//            u2 class_index;
//            u2 name_and_type_index;
//        }

            item.ownerClassIndex = dis.readU2();
            item.nameTypeIndex = dis.readU2();

            return item;
        }

        @Override
        final int getTag() {
            return tag;
        }
    }
}
