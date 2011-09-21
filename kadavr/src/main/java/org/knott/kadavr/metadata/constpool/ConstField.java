/**
 *  ConstField.java : IceBird project
 *  21:41:43 
 */
package org.knott.kadavr.metadata.constpool;

import org.knott.kadavr.metadata.BasicType;
import org.knott.kadavr.metadata.Field;

/**
 * @author sergey
 */
public final class ConstField extends ConstMember {

	/**
	 * @param pool
	 * @param classID
	 * @param signID
	 */
	ConstField(ConstPool pool, int classID, int signID) {
		super(pool, classID, signID);
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_FIELDREF;
	}
	
	/**
	 * Gets basic type descriptor.
	 * @return BasicType
	 */
	public BasicType getType() {
		return BasicType.parse(getDescriptor());
	}
	
	/**
	 * Resolve field defination
	 * @return Field
	 */
	public final Field resolve() {
		return getConstClass().getClassDef().getField(this);
	}
}
