package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ClassItem;
import org.knott.kadavr.metadata.ConstPool;
import org.knott.kadavr.metadata.Utf8Item;

/**
 *
 * @author Sergey
 */
public class InnerClasses extends Attribute {
    public static final String NAME = "InnerClasses";

    private InnerClass[] inners;
    
    @Override
    public void read(ConstPool pool, ClassFileReader dis) 
            throws IOException {      
        //InnerClasses_attribute {
        //    u2 attribute_name_index;
        //    u4 attribute_length;
        //    u2 number_of_classes;
        //    {  u2 inner_class_info_index;	     
        //       u2 outer_class_info_index;	     
        //       u2 inner_name_index;	     
        //       u2 inner_class_access_flags;	     
        //    } classes[number_of_classes];
        //}
        
        int len = dis.readU2();
        inners = new InnerClass[len];
        
        for (int i = 0; i < len; i++) {
            InnerClass inner = new InnerClass();
            inner.read(pool, dis);
            inners[i] = inner;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
    
    public class InnerClass {
        
        private ClassItem innerInfo;
        private ClassItem outerInfo;
        private Utf8Item name;
        private int accessFlags;

        /**
         * Возвратить флаги доступа к данному
         * классу.
         */
        public int getAccessFlags() {
            return accessFlags;
        }

        /**
         * Возвратить информацию о внутренем классе.
         * @return 
         */
        public ClassItem getInnerInfo() {
            return innerInfo;
        }

        /**
         * Возвратить данного класса имя.
         * @return 
         */
        public Utf8Item getName() {
            return name;
        }

        /**
         * Возвратить данные внешнего класса.
         * @return 
         */
        public ClassItem getOuterInfo() {
            return outerInfo;
        }
        
        public void read(ConstPool pool, ClassFileReader dis)
                throws IOException {
            int tmp = dis.readU2();
            if (tmp != 0) {
                innerInfo = pool.getClass(tmp);
            }
            
            tmp = dis.readU2();
            if (tmp != 0) {
                outerInfo = pool.getClass(tmp);
            }
            
            tmp = dis.readU2();
            if (tmp != 0) {
                name = pool.getUtf(tmp);
            }
            
            accessFlags = dis.readU2();
        }
    }
}
