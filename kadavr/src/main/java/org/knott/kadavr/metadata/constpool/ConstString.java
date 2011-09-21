/**
 *  ConstString.java : IceBird project
 *  22:08:38 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public final class ConstString extends ConstObject {

	private int stringID;
	
	/**
	 * @param pool
	 * @param stringID
	 */
	ConstString(ConstPool pool, int stringID) {
		super(pool);
		this.stringID = stringID;
	}

	/**
	 * Gets string.
	 * @return String
	 */
	public String getString() {
		return getConstPool().getString(stringID);
	}

	/* 
	 * (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_STRING;
	}
}
