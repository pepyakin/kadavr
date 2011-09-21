/**
 *  ArrayType.java : IceBird project
 *  3:55:17 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
public final class ArrayType extends BasicType {
	
	private BasicType type;
	
	/**
	 * @return the type
	 */
	public BasicType getType() {
		return type;
	}
	
	/**
	 * Is this array is multidimensional?
	 * @return boolean
	 */
	public boolean isMultiDimensional() {	 
		return getType().isArray();
	}
	
    /**
     * Gets rank of array.
     * @return int
     */
    public int getRank() {
    	if ( !isMultiDimensional() ) return 1;
        return ((ArrayType)getType()).getRank() + 1;
    }

	/**
	 * Construct new ArrayType.
	 * @param contains
	 */
	public ArrayType(BasicType contains) {
		super('[', "array", 4);
		type = contains;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public final String toString() {
		return super.toString() + type.toString();
	}
}
