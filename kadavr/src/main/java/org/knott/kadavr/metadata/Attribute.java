/**
 *  Attribute.java : IceBird project
 *  0:15:32 
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;

import org.knott.kadavr.metadata.constpool.ConstPool;

/**
 * Represents attribute.
 * @author sergey
 */
public class Attribute {

	private KClass owner;
	
	protected int nameID;
	protected byte[] info;
	
	/**
	 * Gets length of attribute(Its info).
	 * @return int
	 */
	public int getLength() {
		return info.length;
	}
	
	/**
	 * Gets info.
	 * @return byte[]
	 */
	public byte[] getInfo() {
		return info;
	}
	
	public String get3() {
		return getConstPool().getString(getInfo()[3]);
	}
	
	/**
	 * Gets string from info.
	 * @return String
	 */
	public String getString() {
		char[] chars = new char[getLength()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)info[i];
		}

		return new String(chars);
	}
	
	/**
	 * Gets string representation.
	 */
	public String toString() {
		return getName();
	}
	
	/**
	 * Gets constant pool.
	 * @return ConstPool
	 */
	public final ConstPool getConstPool() {
		return owner.getConstPool();
	}
	
	/**
	 * Gets name.
	 * @return String
	 */
	public String getName() {
		return getConstPool().getString(nameID);
	}
	
	protected KClass getOwner() {
		return owner;
	}

	/**
	 * @param owner declaring class.
	 */
	Attribute(KClass owner) {
		this.owner = owner;
	}
	
	/**
	 * Read input stream.
	 * @return Attribute
	 */
	public static Attribute read(KClass owner, DataInputStream s) throws IOException {
		ConstPool cp = owner.getConstPool();
		
		int nameID = s.readUnsignedShort();
		int length = s.readInt();
		
		if (cp.getString(nameID).equals("LocalVariableTable")) {
			LocalVariableTable lvt = new LocalVariableTable(owner);
			lvt.readLVT(s);
			return lvt;
		} else if (cp.getString(nameID).equals("Code")) {
			CodeAttribute catt = new CodeAttribute(owner);
			catt.readCode(s);
			return catt;
		}
		
		// Read default(Unknown) attribute.
		Attribute att = new Attribute(owner);
		att.nameID = nameID;
		att.info = new byte[length];
		
		for (int i = 0; i < length; i++) {
			att.info[i] = s.readByte();
		}
		
		return att;
	}
}
