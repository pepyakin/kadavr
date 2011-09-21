/**
 *  ConstSingle.java : IceBird project
 *  22:31:37 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public final class ConstSingle extends ConstObject {
	
	private float value;
	
	/**
	 * @param pool
	 * @param value
	 */
	ConstSingle(ConstPool pool, float value) {
		super(pool);
		this.value = value;
	}

	/**
	 * Gets value.
	 * @return float
	 */
	public float getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_FLOAT;
	}
}
