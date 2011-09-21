/**
 *  Method.java : IceBird project
 *  23:54:36 
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents base class for intstance and class methods.
 * @author sergey
 */
public abstract class Method extends Member {

	/**
	 * @param declType
	 * @param modifiers
	 * @param nameID
	 * @param descriptorID
	 */
	protected Method(KClass declType, int modifiers, int nameID, int descriptorID) {
		super(declType, modifiers, nameID, descriptorID);
		
		if (declType.isFinal()) {
			setModifier(Modifier.ACC_FINAL);
		}
		
		if (Modifier.isPrivate(modifiers)) {
			setModifier(Modifier.ACC_FINAL);
		}
	}
	
//	/**
//	 * Gets full mangled(ANSI C) name.
//	 * @return String
//	 */
//	public final String getMangledName() {
//		if (isNative()) {
//			final String s = "Licebird/Signature;";
//			
//			try {
//			
//				Attribute[] a = getAnnotations();
//				for (Attribute att : a) { 
//					if (att.get3().equals(s)) {
//						return getConstPool().getString(att.getInfo()[13]);
//					}
//				}
//			} catch (Exception e) {}
//		}
//		
//		return getDeclaringType().getMangledName() + 
//			   NameMangler.mangle('#' + getName() + '.' + getDescriptor()).intern();
//	}
	
	/**
	 * Gets full name of this method.
	 * @return String
	 */
	public String getFullName() {
            KClass decl = getDeclaringType();
            
            
		return decl == null ? "" : decl.getName() + '#' +
		       getName() + '!' + getDescriptor();
	}
	
	public final int getLocalsCount() {
		return getCode().getMaxLocals() - getArguments().length;
	}
	
	/**
	 * Get code attribute.
	 * @return CodeAttribute
	 */
	public final CodeAttribute getCode() {
		Attribute[] attributes = getAttributes();
		
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].getName().equals("Code")) {
				return (CodeAttribute)attributes[i];
			}
		}
		
		return null;
	}
	
	/**
	 * Is method is abstract?
	 * @return boolean
	 */
	public final boolean isAbstract() {
		return Modifier.isAbstract(getModifiers());
	}
	
	/**
	 * Is method is native?
	 * @return boolean
	 */
	public final boolean isNative() {
		return Modifier.isNative(getModifiers());
	}
	
	/**
	 * Is method is special.
	 * @return boolean
	 */
	public final boolean isSpecial() {
		return Modifier.isSpecial(getModifiers());
	}
	
	/**
	 * Is method is synchronized?
	 * @return boolean
	 */
	public final boolean isSynchronized() {
		return Modifier.isSynchronized(getModifiers());
	}
	
	/**
	 * Is method is constructor?
	 * @return boolean
	 */
	public final boolean isConstructor() {
		return Modifier.isConstructor(getModifiers());
	}
	
	/**
	 * Is method is static initializer?
	 * @return boolean
	 */
	public final boolean isInitializer() {
		return Modifier.isInitializer(getModifiers());
	}
	
//	/**
//	 * Gets mangled name.
//	 * @return String
//	 */
//	public final String toString() {
//		return getMangledName();
//	}
	
	/**
	 * Gets argument types of method.
	 * @return BasicType[]
	 */
	public BasicType[] getArguments() {
		ArrayList<BasicType> args = new ArrayList<BasicType>();
		String desc = getDescriptor();
		int i = desc.indexOf('(');
		
		while (desc.charAt(i) != ')') {
			if (desc.charAt(i) == '(') {
				i++;
				continue;
			}
			
			BasicType arg = BasicType.parse(desc.substring(i));
			args.add(arg);
			
			i += arg.toString().length();
		}
		
		return args.toArray(new BasicType[args.size()]);
	}
	
	public BasicType getReturnType() {
		String desc = getDescriptor();
		
		int id = desc.indexOf(')') + 1;
		return BasicType.parse(desc.substring(id));
	}
	
	/**
	 * Is this method is empty?
	 * @return boolean
	 */
	public final boolean isEmpty() {
		if (isNative()) return false;
		if (isAbstract()) return false;
		
		return getCode().getLength() == 1;
	}
	
	public final boolean isUnsafe() {
		final String s = "Licebird/Unsafe;";
		
		try {
		
			Attribute[] a = getAnnotations();
			for (Attribute att : a) { 
				if (att.get3().equals(s))
					return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public final Attribute[] getAnnotations() {
		ArrayList<Attribute> att = new ArrayList<Attribute>();
		Attribute[] attached = getAttributes();
		
		for (int i = 0; i < attached.length; i++) {
			if (attached[i].getName().equals("RuntimeInvisibleAnnotations")) {
				att.add(attached[i]);
			} else if (attached[i].getName().equals("RuntimeVisibleAnnotations")) {
				att.add(attached[i]);
			}
		}
		
		return att.toArray(new Attribute[att.size()]);
	}
	
	/**
	 * 
	 * @return Method
	 * @throws IOException when IO error raised.
	 */
	public static final Method fromStream(KClass owner, DataInputStream s) throws IOException {
		int modifiers = s.readUnsignedShort();
		int nameID = s.readUnsignedShort();
		
		Method method = null;
		
		if (SpecialMethod.isSpecial(owner.getConstPool().getString(nameID))) {
			method = new SpecialMethod(owner, modifiers, nameID, 
					s.readUnsignedShort());
		} else if (Modifier.isStatic(modifiers)) {
			method = new StaticMethod(owner, modifiers, nameID,
					s.readUnsignedShort());
		} else {
			method = new InstanceMethod(owner, modifiers, nameID, 
					s.readUnsignedShort());
		}
		
		// Read attached attributes.
		method.readAttributes(s);
		
		return method;
	}

	/**
	 * Is this method returns value?
	 * @return boolean
	 */
	public boolean returns() {
		return getReturnType() != BasicType.Void;
	}
	
//	/**
//	 * Gets most suitable calling conversion.
//	 * @return CallConv
//	 */
//	public CallConv getCallConv() {
//		if (isNative()) return CallConv.NATIVE_CALL;
//		
//		return CallConv.STD_CALL; // Default.
//	}
}
