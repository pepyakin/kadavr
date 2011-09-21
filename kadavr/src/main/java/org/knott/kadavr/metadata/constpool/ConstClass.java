/**
 *  ConstClass.java : IceBird project
 *  21:13:01 
 */
package org.knott.kadavr.metadata.constpool;

import org.knott.kadavr.metadata.KClass;

/**
 * @author sergey
 */
public final class ConstClass extends ConstObject {

	private int nameID = 0;

	/**
	 * @param pool
	 * @param nameID
	 */
	ConstClass(ConstPool pool, int nameID) {
		super(pool);
		this.nameID = nameID;
	}
	
	/**
	 * Gets name of this class.
	 * @return String
	 */
	public String getName() {
		return getConstPool().getString(nameID);
	}
	
	/**
	 * Gets class def.
	 * @return Class
	 */
	public final KClass getClassDef() {
		return org.knott.kadavr.ClassLoader.getClass(getName());
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_CLASS;
	}
}
