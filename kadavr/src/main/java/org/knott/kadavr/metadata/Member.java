/**
 *  Member.java : IceBird project
 *  23:45:54 
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;

import org.knott.kadavr.metadata.constpool.ConstPool;

/**
 * Base class for all member types.
 * @author sergey
 */
public abstract class Member {
	
	private KClass declType;
	
	private int modifiers;
	
	private int nameID;
	private int descriptorID;
	
	private Attribute[] attributes;
	
	/**
	 * @param declType Declaring type
	 * @param modifiers Modifiers.
	 * @param nameID
	 * @param descriptorID
	 */
	protected Member(KClass declType, int modifiers, int nameID, int descriptorID) {	
		this.declType = declType;
		this.modifiers = modifiers;
		this.nameID = nameID;
		this.descriptorID = descriptorID;
		
		if (Modifier.isWide(getDescriptor())) {
			modifiers |= Modifier.ACC_WIDE;
		}
	}
	
	/**
	 * Returns modifiers.
	 * @return int
	 */
	public final int getModifiers() {
		return modifiers;
	}
	
	/**
	 * Set/Reset modifier bit.
	 * @return void
	 */
	public final void setModifier(boolean on, int m) {
		if (on) {
			setModifier(m);
		} else {
			clearModifier(m);
		}
	}
	
	/**
	 * Set modifier bit.
	 * @return void
	 */
	public final void setModifier(int m) {
		modifiers |= m;
	}
	
	/**
	 * Clears modifier bit.
	 * @return void
	 */
	public final void clearModifier(int m) {
		modifiers &= ~m;
	}
	
	/**
	 * Gets constant pool of declaring type.
	 * @return ConstPool
	 */
	public final ConstPool getConstPool() {
		return declType.getConstPool();
	}
	
	/**
	 * Gets name of this member.
	 * @return String
	 */
	public final String getName() {
		return getConstPool().getString(nameID);
	}
	
	/**
	 * Gets descriptor of this member.
	 * @return String
	 */
	public final String getDescriptor() {
		return getConstPool().getString(descriptorID);
	}
	
	/**
	 * Gets declaring type.
	 * @return Class
	 */
	public final KClass getDeclaringType() {
		return declType;
	}
	
	/**
	 * Is this member is public?
	 * @return boolean
	 */
	public final boolean isPublic() {
		return Modifier.isPublic(modifiers);
	}
	
	/**
	 * Is this member is private?
	 * @return boolean
	 */
	public final boolean isPrivate() {
		return Modifier.isPrivate(modifiers);
	}
	
	/**
	 * Is this member is protected?
	 * @return boolean
	 */
	public final boolean isProtected() {
		return Modifier.isProtected(modifiers);
	}
	
	/**
	 * Is this member is static?
	 * @return boolean
	 */
	public final boolean isStatic() {
		return Modifier.isStatic(modifiers);
	}
	
	/**
	 * Is this member is final?
	 * @return boolean
	 */
	public final boolean isFinal() {
		return Modifier.isFinal(modifiers);
	}
	
	/**
	 * @return the attributes
	 */
	public final Attribute[] getAttributes() {
		return attributes;
	}

	protected final void readAttributes(DataInputStream s) throws IOException {
		int count = s.readUnsignedShort();
		attributes = new Attribute[count];
		
		for (int i = 0; i < count; i++) {
			// Read attribute.
			attributes[i] = Attribute.read(getDeclaringType(), s); 
		}
	}
}
