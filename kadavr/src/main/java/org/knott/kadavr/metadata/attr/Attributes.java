package org.knott.kadavr.metadata.attr;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergey
 */
public class Attributes extends AbstractList<Attribute> {

    private List<Attribute> list;
    
    public Attributes(List<Attribute> list) {
        if (list == null) {
            throw new NullPointerException("list can't be null");
        }
        this.list = list;
    }
    
    public Attributes() {
        this(new ArrayList<Attribute>());
    }
    
    /**
     * Содержится ли в списке 
     * заданный аттрибут?
     * @param attrName
     * @return 
     */
    public boolean contains(String attrName) {
        for (Attribute attr : list) {
            if (attr.getName().equals(attrName)) {
                return true;
            }
        }
        
        return false;
    }
    
    public <T extends Attribute> T get(String name) {
        for (Attribute attr : list) {
            if (attr.getName().equals(name)) {
                return (T)attr;
            }
        }
        
        return null;
    }

    @Override
    public Attribute get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(int index, Attribute element) {
        list.add(index, element);
    }

    @Override
    public Attribute remove(int index) {
        return list.remove(index);
    }

    @Override
    public Attribute set(int index, Attribute element) {
        return list.set(index, element);
    } 
}
