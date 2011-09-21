/**
 *  Modifier.java : IceBird project
 *  23:06:52 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
final class Modifier {
	
	static final int ACC_PUBLIC = 0x00000001;
	static final int ACC_PRIVATE = 0x00000002;
	static final int ACC_PROTECTED = 0x00000004;
	static final int ACC_STATIC = 0x00000008;
	static final int ACC_FINAL = 0x00000010;
	static final int ACC_SYNCHRONIZED = 0x00000020;
	static final int ACC_SUPER = 0x00000020;
	static final int ACC_VOLATILE = 0x00000040;
	static final int ACC_TRANSIENT = 0x00000080;
	static final int ACC_NATIVE = 0x00000100;
	static final int ACC_INTERFACE = 0x00000200;
	static final int ACC_ABSTRACT = 0x00000400;
	static final int ACC_STRICT = 0x00000800;
	static final int ACC_SYNTHETIC = 0x00001000;
	static final int ACC_ANNOTATION = 0x00002000;
	static final int ACC_ENUM = 0x00004000;
	static final int ACC_WIDE = 0x00010000;
	static final int ACC_OBJECTREF = 0x00020000;
	static final int ACC_INITIALIZER = 0x00040000;
	static final int ACC_CONSTRUCTOR = 0x00080000;
	static final int ACC_FINALIZER = 0x00100000;
	static final int ACC_SPECIAL = 0x80000000;
	
	/**
	 * Checks is flag presents.
	 * @param m Modifier to check.
	 * @param f Flags to presense check.
	 * @return boolean is flag setted?
	 */
	private static boolean isFlagSetted(int m, int f) {
		return (m & f) != 0;
	}
	
	/**
	 * Is ACC_PUBLIC flag setted?
	 * @return boolean
	 */
	public static boolean isPublic(int m) {
		return isFlagSetted(m, ACC_PUBLIC);
	}
	
	/**
	 * Is ACC_PRIVATE flag setted?
	 * @return boolean
	 */
	public static boolean isPrivate(int m) {
		return isFlagSetted(m, ACC_PRIVATE);
	}
	
	/**
	 * Is ACC_PROTECTED flag setted?
	 * @return boolean
	 */
	public static boolean isProtected(int m) {
		return isFlagSetted(m, ACC_PROTECTED);
	}
	
	/**
	 * Is ACC_STATIC flag setted?
	 * @return boolean
	 */
	public static boolean isStatic(int m) {
		return isFlagSetted(m, ACC_STATIC);
	}
	
	/**
	 * Is ACC_FINAL flag setted?
	 * @return boolean
	 */
	public static boolean isFinal(int m) {
		return isFlagSetted(m, ACC_FINAL);
	}
	
	/**
	 * Is ACC_OBJECTREF flag setted?
	 * @return boolean
	 */
	public static boolean isObjectRef(int m) {
		return isFlagSetted(m, ACC_OBJECTREF);
	}
	
	/**
	 * Is ACC_SYNCHRONIZED flag setted?
	 * @return boolean
	 */
	public static boolean isSynchronized(int m) {
		return isFlagSetted(m, ACC_SYNCHRONIZED);
	}
	
	/**
	 * Is ACC_SUPER flag setted?
	 * @return boolean
	 */
	public static boolean isSuper(int m) {
		return isFlagSetted(m, ACC_SUPER);
	}
	
	/**
	 * Is ACC_VOLATILE flag setted?
	 * @return boolean
	 */
	public static boolean isVolatile(int m) {
		return isFlagSetted(m, ACC_VOLATILE);
	}
	
	/**
	 * Is ACC_TRANSIENT flag setted?
	 * @return boolean
	 */
	public static boolean isTransient(int m) {
		return isFlagSetted(m, ACC_TRANSIENT);
	}
	
	/**
	 * Is ACC_NATIVE flag setted?
	 * @return boolean
	 */
	public static boolean isNative(int m) {
		return isFlagSetted(m, ACC_NATIVE);
	}
	
	/**
	 * Is ACC_INTERFACE flag setted?
	 * @return boolean
	 */
	public static boolean isInterface(int m) {
		return isFlagSetted(m, ACC_INTERFACE);
	}
	
	/**
	 * Is ACC_ENUM flag setted?
	 * @return boolean
	 */
	public static boolean isEnum(int m) {
		return isFlagSetted(m, ACC_ENUM);
	}
	
	/**
	 * Is ACC_ABSTRACT flag setted?
	 * @return boolean
	 */
	public static boolean isAbstract(int m) {
		return isFlagSetted(m, ACC_ABSTRACT);
	}
	
	/**
	 * Is ACC_STRICT flag setted?
	 * @return boolean
	 */
	public static boolean isStrict(int m) {
		return isFlagSetted(m, ACC_STRICT);
	}
	
	/**
	 * Is ACC_INITIALIZER flag setted?
	 * @return boolean
	 */
	public static boolean isInitializer(int m) {
		return isFlagSetted(m, ACC_INITIALIZER);
	}
	
	/**
	 * Is ACC_CONSTRUCTOR flag setted?
	 * @return boolean
	 */
	public static boolean isConstructor(int m) {
		return isFlagSetted(m, ACC_CONSTRUCTOR);
	}
	
	/**
	 * Is ACC_SPECIAL flag setted?
	 * @return boolean
	 */
	public static boolean isSpecial(int m) {
		return isFlagSetted(m, ACC_SPECIAL);
	}
	
	/**
	 * Is ACC_FINALIZER flag setted?
	 * @return boolean
	 */
	public static boolean isFinalizer(int m) {
		return isFlagSetted(m, ACC_FINALIZER);
	}
	
	/**
	 * Is signature represent wide java type.
	 * @return boolean
	 */
	public static boolean isWide(String signature) {
		if (signature == null) {
			throw new IllegalArgumentException();
		}
		
		int len = signature.length();
		boolean isArray = (len > 1) && (signature.charAt(len - 2) == '[');
		
		if (isArray) {
			return false;
		} else {
			char ch = signature.charAt(len - 1);
			return ((ch == 'J') || (ch == 'D'));
		}
	}
	
	/**
	 * Is ACC_WIDE flag setted?
	 * @return boolean
	 */
	public static boolean isWide(int m) {
		return isFlagSetted(m, ACC_WIDE);
	}
	
	/**
	 * Is signature repsent primitive java type(Not reference or array).
	 * @return boolean
	 */
	public static boolean isPrimitive(String signature) {
		char ch = signature.charAt(0);
		return ((ch != '[') && (ch != 'L'));
	}

	/* Dont allow creation. */
	private Modifier() {
	}
}
