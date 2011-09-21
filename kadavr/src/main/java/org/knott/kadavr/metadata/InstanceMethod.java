/**
 *  InstanceMethod.java : IceBird project
 *  0:10:27 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
public class InstanceMethod extends Method {

	/**
	 * @param declType
	 * @param modifiers
	 * @param nameID
	 * @param descriptorID
	 */
	public InstanceMethod(KClass declType, int modifiers, int nameID,
			int descriptorID) {
		super(declType, modifiers, nameID, descriptorID);
	}
}
