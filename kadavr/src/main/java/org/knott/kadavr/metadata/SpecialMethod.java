/**
 *  SpecialMethod.java : IceBird project
 *  0:05:17 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
public final class SpecialMethod extends StaticMethod {

	/**
	 * @param declType
	 * @param modifiers
	 * @param nameID
	 * @param descriptorID
	 */
	SpecialMethod(KClass declType, int modifiers, int nameID,
			int descriptorID) {
		super(declType, modifiers, nameID, descriptorID);
		
		setModifier(Modifier.ACC_SPECIAL);
		
		if (!isSpecial(getName())) {
			throw new RuntimeException("Tried to assign a special" +
					                   " method, for non special");
		}
		
		if (getName().equals("<init>")) {
			setModifier(Modifier.ACC_CONSTRUCTOR);
		} else if (getName().equals("<clinit>")) {
			setModifier(Modifier.ACC_INITIALIZER);
		} else {
			throw new RuntimeException("Tried to assign a special" +
            " method, for non special");
		}
	}

	/**
	 * Is this method name represents special method.
	 * @return boolean
	 */
	public static boolean isSpecial(String name) {
		if (name.equals("<init>") || name.equals("<clinit>"))
			return true;
		
		return false;
	}
}
