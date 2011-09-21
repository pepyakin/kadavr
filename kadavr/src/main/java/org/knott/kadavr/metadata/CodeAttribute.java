/**
 *  CodeAttribute.java : IceBird project
 *  0:41:54 
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author sergey
 */
public final class CodeAttribute extends Attribute {
	
	private int maxLocals;
	private int maxStack;
	
	private int codeLength;
	private byte[] code;
	
	private ExceptionEntry[] exceptions;
	private Attribute[] attributes;

	/**
	 * @param owner
	 */
	public CodeAttribute(KClass owner) {
		super(owner);
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.Attribute#getInfo()
	 */
	public byte[] getInfo() {
		throw new IllegalStateException();
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.Attribute#getLength()
	 */
	public int getLength() {
		return 10 + codeLength;
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.Attribute#getName()
	 */
	public String getName() {
		return "Code";
	}
	
	/**
	 * @return the attributes
	 */
	public final Attribute[] getAttributes() {
		return attributes;
	}

	/**
	 * @return the code
	 */
	public final byte[] getCode() {
		return code;
	}

	/**
	 * @return the codeLength
	 */
	public final int getCodeLength() {
		return codeLength;
	}

	/**
	 * @return the exceptions
	 */
	public final ExceptionEntry[] getExceptions() {
		return exceptions;
	}

	/**
	 * @return the maxLocals
	 */
	public final int getMaxLocals() {
		return maxLocals;
	}

	/**
	 * @return the maxStack
	 */
	public final int getMaxStack() {
		return maxStack;
	}

	/**
	 * Read code.
	 * @return void
	 */
	void readCode(DataInputStream s) throws IOException {
		maxStack = s.readUnsignedShort();
		maxLocals = s.readUnsignedShort();
		
		codeLength = s.readInt();
		code = new byte[codeLength];
		for (int i = 0; i < codeLength; i++) {
			code[i] = s.readByte();
		}
		
		int exCount = s.readUnsignedShort();
		exceptions = new ExceptionEntry[exCount];
		
		for (int i = 0; i < exCount; i++) {
			exceptions[i] = new ExceptionEntry(getOwner(), s);
		}
		
		int attCount = s.readUnsignedShort();
		attributes = new Attribute[attCount];
		
		for (int i = 0; i < attCount; i++) {
			attributes[i] = Attribute.read(getOwner(), s);
		}		
	}
}
