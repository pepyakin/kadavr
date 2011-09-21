/**
 *  ConstIMethod.java : IceBird project
 *  22:06:37 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public final class ConstIMethod extends ConstMethod {

	/**
	 * @param pool
	 * @param classID
	 * @param signID
	 */
	ConstIMethod(ConstPool pool, int classID, int signID) {
		super(pool, classID, signID);
	}

	/*
	 * (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstMethod#getTag()
	 */
	public final byte getTag() {
		return CONST_IMETHODREF;
	}
}
