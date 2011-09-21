/**
 *  LVTEntry.java : IceBird project
 *  0:23:07 
 */
package org.knott.kadavr.metadata;

/**
 * Represents local variable table entry.
 * @author sergey
 */
public final class LVTEntry {

	private int startPC;
	private int length;
	private int index;
	
	/**
	 * @param startPC
	 * @param length
	 * @param index
	 */
	LVTEntry(int startPC, int length) {
		this.startPC = startPC;
		this.length = length;
	}
	
	void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Gets start address of variable.
	 * @return int
	 */
	public int getStartPC() {
		return startPC;
	}
	
	/**
	 * Gets end address of variable.
	 * @return int
	 */
	public int getEndPC() {
		return startPC + length;
	}
	
	/**
	 * Gets index of variable.
	 * @return int
	 */
	public int getIndex() {
		return index;
	}
}
