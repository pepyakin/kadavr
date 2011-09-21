/**
 *  BasicType.java : IceBird project
 *  3:06:05 
 */
package org.knott.kadavr.metadata;


/**
 * Defines basic JavaVM primitive type, such as short or void.
 * Or canbe Reference on Class.
 * @author sergey
 */
public class BasicType {
	
	private char ch = 0;
	private int size = 1;
	
	private String typeName;
	
	
	/**
	 * Is this type is wide?
	 * @return boolean
	 */
	public boolean isWide() {
		return size == 8;
	}
	
	/**
	 * Is this type is primitive?
	 * @return boolean
	 */
	public boolean isPrimitive() {
		return !isArray() && ch != 'L';
	}
	
	/**
	 * Is this type is array?
	 * @return boolean
	 */
	public boolean isArray() {
		return ch == '[';
	}

	/**
	 * @return the character
	 */
	public char getCharacter() {
		return ch;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * @param ch Type character.
	 * @param size Type size.
	 * @param typeName Type name.
	 */
	protected BasicType(char ch,String typeName, int size) {
		this.ch = ch;
		this.size = size;
		this.typeName = typeName;
	}
	
    public static final BasicType Byte = new BasicType('B', "byte", 1);
    public static final BasicType Char = new BasicType('C', "char", 2);
    public static final BasicType Double = new BasicType('D', "double", 8);
    public static final BasicType Float = new BasicType('F', "float", 4);
    public static final BasicType Int = new BasicType('I', "int", 4);
    public static final BasicType Long = new BasicType('J', "long", 8);
    public static final BasicType Short = new BasicType('S', "short", 2);
    public static final BasicType Boolean = new BasicType('Z', "boolean", 1);
    public static final BasicType Void = new BasicType('V', "void", 1);
    public static final BasicType ReturnAddress = new BasicType('R', "return", 4); 
    
    /**
     * Parse for basic type.
     * @return BasicType
     */
    public static final BasicType parse(String desc) throws ClassFormatError {
    	char ch = Character.toUpperCase(desc.charAt(0));
    	
    	switch (ch) {
    		case 'B':
    			return Byte;
    			
    		case 'C':
    			return Char;
    			
    		case 'D':
    			return Double;
    			
    		case 'F':
    			return Float;
    			
    		case 'I':
    			return Int;
    			
    		case 'J':
    			return Long;
    			
    		case 'S':
    			return Short;
    			
    		case 'Z':
    			return Boolean;
    			
    		case 'V':
    			return Void;
    			
    		case 'L':
    			int idx = desc.indexOf(';', 1);
    			if (idx == -1) {
    				throw new ClassFormatError();
    			}
    			
    			// Extracts class name from descriptor.
                String className = desc.substring(1, idx);
                return new ReferenceType(className);
    			
    		case '[':
    			return new ArrayType(
    					parse(desc.substring(1)
    					));
    	
    		default:
    			throw new ClassFormatError("Unknown signature char " + ch);
		}
    }

	public int getCategory() {
		if (isWide()) {
			return 2;
		} else return 1;
	}
	
	public String toString() {
		return String.valueOf(ch);
	}
}
