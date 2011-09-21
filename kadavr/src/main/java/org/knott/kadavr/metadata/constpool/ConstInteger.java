/**
 *  ConstInteger.java : IceBird project
 *  22:29:00 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public final class ConstInteger extends ConstObject {

	private int value; 
	
	/**
	 * @param pool
	 * @param value
	 */
	ConstInteger(ConstPool pool, int value) {
		super(pool);
		this.value = value;
	}

	/**
	 * Gets value.
	 * @return int
	 */
	public int getValue() {
		return value;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_INTEGER;
	}
}
