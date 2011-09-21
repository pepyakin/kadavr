/**
 *  ConstUTF8.java : IceBird project
 *  21:21:47 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public final class ConstUTF8 extends ConstObject {
	
	private String value = null;
	
	/**
	 * @param pool
	 * @param value
	 */
	ConstUTF8(ConstPool pool, String value) {
		super(pool);
		this.value = value;
	}
	
	/**
	 * Gets string.
	 * @return String
	 */
	public String getString() {
		return value;
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_UTF8;
	}
}
