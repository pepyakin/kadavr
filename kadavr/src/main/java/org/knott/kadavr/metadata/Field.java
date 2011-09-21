/**
 *  Field.java : IceBird project
 *  1:00:52 
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;


/**
 * Represents base class for instance and class fields.
 * @author sergey
 */
public abstract class Field extends Member {

	/**
	 * @param declType
	 * @param modifiers
	 * @param nameID
	 * @param descriptorID
	 */
	protected Field(KClass declType, int modifiers, int nameID, int descriptorID) {
		super(declType, modifiers, nameID, descriptorID);
		
		if (Modifier.isWide(getDescriptor())) {
			setModifier(Modifier.ACC_WIDE);
		}
	}
	
	/**
	 * Extracts type from descriptor.
	 * @return BasicType
	 */
	public BasicType getType() {
		return BasicType.parse(getDescriptor());
	}

	/**
	 * Is this type is transient?
	 * @return boolean
	 */
	public boolean isTransient() {
		return Modifier.isTransient(getModifiers());
	}
	
	/**
	 * Is this field is primitive?
	 * @return boolean
	 */
	public boolean isPrimitive() {
		return getType().isPrimitive();
	}
	
	/**
	 * Is this field contains object ref?
	 * @return boolean
	 */
	public boolean isObjectRef() {
		return Modifier.isObjectRef(getModifiers());
	}
	
	/**
	 * Wide
	 * @return boolean
	 */
	public boolean isWide() {
		return Modifier.isWide(getModifiers());
	}
//	
//	/**
//	 * Gets mangled name.
//	 * @return String
//	 */
//	public final String getMangledName() {
//		return NameMangler.mangleClassName(getDeclaringType().getName()) +
//			NameMangler.mangle('.' + getName() + '.' + getDescriptor());
//	}
	
//	/**
//	 * Gets string representation.
//	 * @return String
//	 */
//	public String toString() {
//		return getMangledName();
//	}
	
	/**
	 * 
	 * @return Field
	 * @throws IOException when IO error raised.
	 */
	public static Field fromStream(KClass owner, DataInputStream s) throws IOException {
		int modifiers = s.readUnsignedShort();
		int nameID = s.readUnsignedShort();
		
		Field field = null;
		
		if (Modifier.isStatic(modifiers)) {
			field = new StaticField(owner, modifiers, nameID,
					s.readUnsignedShort());
		} else {
			field = new InstanceField(owner, modifiers, nameID,
					s.readUnsignedShort());
		}
		
		field.readAttributes(s);
		
		return field;
	}
}
