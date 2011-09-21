/**
 *  ConstSignature.java : IceBird project
 *  21:33:31 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * Represents signature(Name and Type) constant
 * pool entry.
 * @author sergey
 */
public final class ConstSignature extends ConstObject {
	
	private int nameID;
	private int descriptorID;
	
	/**
	 * @param pool
	 * @param nameID
	 * @param descriptorID
	 */
	ConstSignature(ConstPool pool, int nameID, int descriptorID) {
		super(pool);
		this.nameID = nameID;
		this.descriptorID = descriptorID;
	}
	
	/**
	 * Gets name part of signature.
	 * @return String
	 */
	public String getName() {
		return getConstPool().getString(nameID);
	}
	
	/**
	 * Gets descriptor part of signature.
	 * @return String
	 */
	public String getDescriptor() {
		return getConstPool().getString(descriptorID);
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_NAMEANDTYPE;
	}
}
