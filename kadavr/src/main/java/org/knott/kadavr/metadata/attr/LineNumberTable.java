package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;

/**
 *
 * @author Sergey
 */
public class LineNumberTable extends Attribute {

    /**
     * Имя данного аттрибута.
     */
    public static final String NAME = "LineNumberTable";

    private LineNumber[] lineMap;

    public int count() {
        return lineMap.length;
    }

    public LineNumber get(int i) {
        return lineMap[i];
    }

    @Override
    public void read(ConstPool pool, ClassFileReader dis)
            throws IOException {
        //LineNumberTable_attribute {
        //    u2 attribute_name_index;
        //    u4 attribute_length;
        //    u2 line_number_table_length;
        //    {  u2 start_pc;
        //       u2 line_number;
        //    } line_number_table[line_number_table_length];
        //}
        int len = dis.readU2();
        lineMap = new LineNumber[len];

        for (int i = 0; i < len; i++) {
            LineNumber lineNo = new LineNumber();
            lineNo.read(dis);
            lineMap[i] = lineNo;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    public static class LineNumber {

        private int pc;
        private int lineNo;

        public int getLineNo() {
            return lineNo;
        }

        public int getPc() {
            return pc;
        }

        public void read(ClassFileReader dis)
                throws IOException {
            pc = dis.readU2();
            lineNo = dis.readU2();
        }
    }
}
