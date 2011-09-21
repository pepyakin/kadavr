/**
 *  StaticField.java : IceBird project
 *  1:09:44 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
public class StaticField extends Field {

	/**
	 * @param declType
	 * @param modifiers
	 * @param nameID
	 * @param descriptorID
	 */
	public StaticField(KClass declType, int modifiers, int nameID,
			int descriptorID) {
		super(declType, modifiers, nameID, descriptorID);
	}

	/**
	 * Returns static name.
	 */
	public final String toString() {
		return getDeclaringType().getName() + "." + getName();
	}
}
