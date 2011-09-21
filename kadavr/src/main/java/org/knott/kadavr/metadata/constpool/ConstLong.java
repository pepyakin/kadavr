/**
 *  ConstLong.java : IceBird project
 *  22:35:21 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public final class ConstLong extends ConstObject {
	
	private long value;
	
	/**
	 * @param pool
	 * @param value
	 */
	ConstLong(ConstPool pool, long value) {
		super(pool);
		this.value = value;
	}

	/**
	 * Gets value.
	 * @return long
	 */
	public long getValue() {
		return value;
	}

	/* 
	 * (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_LONG;
	}
}
