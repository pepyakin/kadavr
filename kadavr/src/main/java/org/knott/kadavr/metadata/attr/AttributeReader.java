package org.knott.kadavr.metadata.attr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;

/**
 * Вспомогательный класс для чтения
 * аттрибутов.
 * 
 * @author Sergey
 */
public class AttributeReader {
    
    private ConstPool constPool;
    private Map<String, Class<? extends Attribute>> mapping;

    public AttributeReader(ConstPool constPool) {
        if (constPool == null)
            throw new NullPointerException("constPool can't be null");
        
        this.constPool = constPool;
        mapping = new HashMap<String, Class<? extends Attribute>>();
        addDefaultMapping();
    }
    
    public Attributes read(ClassFileReader dis) 
            throws IOException {
        //    .. 
        //    u2 attributes_count;
    	//    attribute_info attributes[attributes_count];
        //}
        
        //attribute_info {
        //    u2 attribute_name_index;
        //    u4 attribute_length;
        //    u1 info[attribute_length];
        //}
        int count = dis.readU2();
        Attribute[] attrs = new Attribute[count];
        
        for (int i = 0; i < count; i++) {
            String name = constPool.getUtf(dis.readU2()).get();
            Class<? extends Attribute> resolved = resolve(name);            
            
            // Считать данные принадлежащие
            // аттрибуту.
            int dataLen = (int)dis.readU4();
            byte[] data = new byte[dataLen];
            dis.read(data);
            
            // Этот аттрибут не определён в спецификации, пропускаем его.
            if (resolved == null) continue;
            
            // Засумонить аттрибут из соответсвующего
            // класса.
            Attribute attribute = null;
            try {
                attribute = resolved.newInstance();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            
            // Считать аттрибут.
            attribute.read(constPool, wrap(data));
            attrs[i] = attribute;
        }
        
        return new Attributes(Arrays.asList(attrs));
    }
    
    /**
     * Обвернуть данные для считывания в 
     * поток.
     * @param data
     * @return 
     */
    private ClassFileReader wrap(byte[] data) {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        return new ClassFileReader(bais);
    }
    
    private Class<? extends Attribute> resolve(String name) {
        if (mapping.containsKey(name)) {
            return mapping.get(name);
        }
        return null;
    }

    private void addDefaultMapping() {
        mapping.put("Code", Code.class);
        mapping.put("ConstantValue", ConstantValue.class);
        mapping.put("Deprecated", Deprecated.class);
        mapping.put("Exceptions", Exceptions.class);
        mapping.put("InnerClasses", InnerClasses.class);
        mapping.put("LineNumberTable", LineNumberTable.class);
        mapping.put("LocalVariableTable", LocalVariableTable.class);
        mapping.put("SourceFile", SourceFile.class);
        mapping.put("Synthetic", Synthetic.class);
    }
    
    public void bind(String name, Class<? extends Attribute> c) {
        mapping.put(name, c);
    }
    
    public void unbind(String name) {
        mapping.remove(name);
    }
}
