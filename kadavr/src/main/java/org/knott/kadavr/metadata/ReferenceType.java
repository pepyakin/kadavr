/**
 *  ReferenceType.java : IceBird project
 *  3:12:23 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
public final class ReferenceType extends BasicType {
	
	private String className;
		
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Construct new ReferenceType
	 * @param className
	 */
	public ReferenceType(String className) {		
		super('L', "reference", 4);
		
		if (className == null) {
			//throw new IllegalArgumentException();
		}
		
		this.className = className;
	}

	/**
	 * Returns string representation.
	 */
	public final String toString() {
		if (className == null) {
			return "<unknown ref>";
		}
		
		return super.toString() + className + ';';
	}
}
