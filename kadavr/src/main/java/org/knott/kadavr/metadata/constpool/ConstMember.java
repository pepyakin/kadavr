/**
 *  ConstMember.java : IceBird project
 *  21:29:57 
 */
package org.knott.kadavr.metadata.constpool;


/**
 * @author sergey
 */
public abstract class ConstMember extends ConstObject {
	
	private int classID;
	private int signID;
	
	/**
	 * Constructs const member.
	 * @param pool
	 * @param classID
	 * @param signID
	 */
	protected ConstMember(ConstPool pool, int classID, int signID) {
		super(pool);
		this.classID = classID;
		this.signID = signID;
	}

	/**
	 * Gets declaring class.
	 * @return ConstClass
	 */
	public final ConstClass getConstClass() {
		return getConstPool().getConstClass(classID);
	}
	
	/**
	 * Gets signature of member.
	 * @return ConstSignature
	 */
	public final ConstSignature getConstSignature() {
		return getConstPool().getConstSignature(signID);
	}
	
	/**
	 * Get name of this member.
	 * @return String
	 */
	public final String getName() {
		return getConstSignature().getName();
	}
	
	/**
	 * Gets signature of this member.
	 * @return String
	 */
	public final String getDescriptor() {
		return getConstSignature().getDescriptor();
	}
}
