/**
 *  StaticMethod.java : IceBird project
 *  0:03:58 
 */
package org.knott.kadavr.metadata;

/**
 * Represents static method(aka Class method).
 * @author sergey
 */
public class StaticMethod extends Method {

	/**
	 * @param declType
	 * @param modifiers
	 * @param nameID
	 * @param descriptorID
	 */
	StaticMethod(KClass declType, int modifiers, int nameID,
			int descriptorID) {
		super(declType, modifiers, nameID, descriptorID);

		setModifier(Modifier.ACC_STATIC);
	}
}
