/**
 *  ConstPool.java : IceBird project
 *  21:13:46 
 */
package org.knott.kadavr.metadata.constpool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Represents class constant pool.
 * @author sergey
 */
public final class ConstPool {
	
	private static final int CONST_CLASS = 7;
	private static final int CONST_FIELDREF = 9;
	private static final int CONST_METHODREF = 10;
	private static final int CONST_IMETHODREF = 11;
	private static final int CONST_STRING = 8;
	private static final int CONST_INTEGER = 3;
	private static final int CONST_FLOAT = 4;
	private static final int CONST_LONG = 5;
	private static final int CONST_DOUBLE = 6;
	private static final int CONST_NAMEANDTYPE = 12;
	private static final int CONST_UTF8 = 1;
	
	private ConstObject[] pool;
	
	/**
	 * Creates new empty constant pool.
	 * @param count
	 */
	public ConstPool(int count) {
		pool = new ConstObject[count];
	}
	
	/**
	 * Gets length of this constant pool.
	 * @return int
	 */
	public int getLength() {
		return pool.length;
	}
	
	/**
	 * Gets double. Index must be valid
	 * CONST_DOUBLE entry.
	 * @return double
	 */
	public double getDouble(int index) {
		if (!checkValid(index, CONST_DOUBLE)) {
			throw new ConstPoolError();
		}
		
		return ((ConstDouble)get(index)).getValue();
	}
	
	/**
	 * Gets long. Index must be valid
	 * CONST_LONG entry.
	 * @return long
	 */
	public long getLong(int index) {
		if (!checkValid(index, CONST_LONG)) {
			throw new ConstPoolError();
		}
		
		return ((ConstLong)get(index)).getValue();
	}
	
	/**
	 * Gets float. Index must be valid
	 * CONST_FLOAT entry.
	 * @return float
	 */
	public float getFloat(int index) {
		if (!checkValid(index, CONST_FLOAT)) {
			throw new ConstPoolError();
		}
		
		return ((ConstSingle)get(index)).getValue();
	}
	
	/**
	 * Gets integer. Index must be valid
	 * CONST_INTEGER entry.
	 * @return int
	 */
	public int getInteger(int index) {
		if (!checkValid(index, CONST_INTEGER)) {
			throw new ConstPoolError();
		}
		
		return ((ConstInteger)get(index)).getValue();
	}
	
	/**
	 * Gets const signature. Index must be valid
	 * CONST_NAMEANDTYPE entry.
	 * @return ConstClass
	 */
	public ConstSignature getConstSignature(int index) {
		if (!checkValid(index, CONST_NAMEANDTYPE)) {
			throw new ConstPoolError();
		}
		
		return ((ConstSignature)get(index));
	}
	
	/**
	 * Gets const class. Index must be valid
	 * CONST_CLASS entry.
	 * @return ConstClass
	 */
	public ConstClass getConstClass(int index) {
		if (!checkValid(index, CONST_CLASS)) {
			throw new ConstPoolError();
		}
		
		return ((ConstClass)get(index));
	}
	
	/**
	 * Gets string. Index must be valid 
	 * CONST_UTF8 or CONST_STRING entry.
	 * @return String
	 */
	public String getString(int index) {
		if (!checkValid(index)) {
			throw new ConstPoolError();
		}
		
		if (checkValid(index, CONST_UTF8)) {
			return ((ConstUTF8)get(index)).getString();
		} else if (checkValid(index, CONST_STRING)) {
			return ((ConstString)get(index)).getString();
		} else {
			throw new ConstPoolError();
		}
	}
	
	/**
	 * Get method reference. Index must be valid
	 * CONST_METHODREF entry.
	 * @return ConstMethod
	 */
	public ConstMethod getMethod(int index) {
		if (!checkValid(index, CONST_METHODREF)) {
			throw new ConstPoolError();
		}
		
		return ((ConstMethod)get(index));
	}
	
	/**
	 * Gets field reference. Index must be valid
	 * CONST_FIELDREF entry.
	 * @return ConstField
	 */
	public ConstField getField(int index) {
		if (!checkValid(index, CONST_FIELDREF)) {
			throw new ConstPoolError();
		}
		
		return ((ConstField)get(index));
	}
	
	/**
	 * Get method reference. Index must be valid
	 * CONST_IMETHODREF entry.
	 * @return ConstIMethod
	 */
	public ConstIMethod getIMethod(int index) {
		if (!checkValid(index, CONST_IMETHODREF)) {
			throw new ConstPoolError();
		}
		
		return ((ConstIMethod)get(index));
	}
	
	/**
	 * Parses stream for constant pool entries.
	 * @return ConstPool
	 */
	public static ConstPool read(DataInputStream s) throws IOException {
		int count = s.readUnsignedShort() - 1;
		ConstPool constPool = new ConstPool(count);
		
		for (int i = 0; i < count; i++) {
			ConstObject obj = parse(s, constPool);
			
			if (obj != null)
				constPool.pool[i] = obj; 
		}
		
		return constPool;
	}
	
	/**
	 * Parses new constant pool entry.
	 * @return ConstObject
	 */
	private static ConstObject parse(DataInputStream s, ConstPool cp) throws IOException {
		int tag = s.readUnsignedByte();
		
		switch (tag) {
		
		case 1:
			return new ConstUTF8(cp, readString(s));
		
		case 3:
			return new ConstInteger(cp,
					s.readInt());
		
		case 4:
			return new ConstSingle(cp,
					s.readFloat());
		
		case 5:
			return new ConstLong(cp,
					s.readLong());

		case 6:
			return new ConstDouble(cp,
					s.readDouble());
		
		case 7:
			return new ConstClass(cp,
					s.readUnsignedShort());
			
		case 8:
			return new ConstString(cp, 
					s.readUnsignedShort());
			
		case 9:
			return new ConstField(cp,
					s.readUnsignedShort(),
					s.readUnsignedShort());
			
		case 10:
			return new ConstMethod(cp,
					s.readUnsignedShort(),
					s.readUnsignedShort());
			
		case 11:
			return new ConstIMethod(cp,
					s.readUnsignedShort(),
					s.readUnsignedShort());
			
		case 12:
			return new ConstSignature(cp,
					s.readUnsignedShort(),
					s.readUnsignedShort());
			
		default:
			throw new ConstPoolError();
		}
	}
	
	/**
	 * Read string from stream.
	 * @return String
	 */
	private static String readString(DataInputStream s) throws IOException {
		int length = s.readUnsignedShort();
		byte[] bytes = new byte[length];
		
		for (int i = 0; i < length; i++) {
			bytes[i] = s.readByte();
		}
		
		return new String(bytes).intern();
	}
	
	/**
	 * Safeless(Without any type-cheking) get object.
	 * @return ConstObject
	 */
	private ConstObject get(int index) {	
		return pool[index - 1];
	}
	
	/**
	 * Gets type of constant.
	 * @return int
	 */
	public int getType(int index) {
		if (!checkValid(index)) {
			throw new ConstPoolError();
		}
		
		return get(index).getTag();
	}
	
	/**
	 * Checks, is index valid?
	 * @return void
	 */
	private boolean checkValid(int index) {
		return ((index > 0) && (index < getLength() + 1));
	}
	
	/**
	 * Checks, is index and type valid?
	 * @return void
	 */
	private boolean checkValid(int index, int type) {
		if (!checkValid(index)) 
			return false;
		
		ConstObject obj = get(index);
		return obj.getTag() == type;
	}
}
