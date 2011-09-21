/**
 *  InstanceField.java : IceBird project
 *  1:08:10 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
public final class InstanceField extends Field {

	private int offset;
	
	/**
	 * @param declType
	 * @param modifiers
	 * @param nameID
	 * @param descriptorID
	 */
	InstanceField(KClass declType, int modifiers, int nameID, int descriptorID) {
		super(declType, modifiers, nameID, descriptorID);
	}

	/**
	 * @return the offset
	 */
	public final int getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public final void setOffset(int offset) {
		this.offset = offset;
	}
}
