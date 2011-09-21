/**
 *  ConstObject.java : IceBird project
 *  21:10:54 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * Represnts base class for all constant pool entries.
 * @author sergey
 */
public abstract class ConstObject {

	private ConstPool pool = null;
	
	/**
	 * Constructs base object.
	 * @param pool Constnant pool.
	 */
	protected ConstObject(ConstPool pool) {
		if (pool == null) {
			throw new IllegalArgumentException();
		}
		
		this.pool = pool;
	}
	
	/**
	 * Gets constant pool.
	 * @return ConstPool
	 */
	public final ConstPool getConstPool() {
		return pool;
	}
	
	/**
	 * Gets one byte tag. 
	 * @return byte
	 */
	public abstract byte getTag();
	
	public static final int CONST_CLASS = 7;
	public static final int CONST_FIELDREF = 9;
	public static final int CONST_METHODREF = 10;
	public static final int CONST_IMETHODREF = 11;
	public static final int CONST_STRING = 8;
	public static final int CONST_INTEGER = 3;
	public static final int CONST_FLOAT = 4;
	public static final int CONST_LONG = 5;
	public static final int CONST_DOUBLE = 6;
	public static final int CONST_NAMEANDTYPE = 12;
	public static final int CONST_UTF8 = 1;
}
