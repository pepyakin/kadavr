/**
 *  ConstDouble.java : IceBird project
 *  22:38:27 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public final class ConstDouble extends ConstObject {

	private double value;
	
	/**
	 * @param pool
	 * @param value
	 */
	ConstDouble(ConstPool pool, double value) {
		super(pool);
		this.value = value;
	}

	/**
	 * Gets value.
	 * @return double
	 */
	public double getValue() {
		return value;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_DOUBLE;
	}
}
