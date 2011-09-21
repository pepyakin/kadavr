/**
 *  LocalVariableTable.java : IceBird project
 *  0:21:54 
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author sergey
 */
public final class LocalVariableTable extends Attribute {

	private LVTEntry[] locals;
	
	/**
	 * @param owner
	 */
	public LocalVariableTable(KClass owner) {
		super(owner);
	}
	
	/* (non-Javadoc)
	 * @see icebird.metadata.Attribute#getName()
	 */
	public final String getName() {
		return "LocalVariableTable";
	}

	/**
	 * Read data.
	 * @return void
	 */
	void readLVT(DataInputStream s) throws IOException {
		int length = s.readUnsignedShort();
		locals = new LVTEntry[length];
		
		for (int i = 0; i < length; i++) {
			locals[i] = new LVTEntry(
				s.readUnsignedShort(),
				s.readUnsignedShort());
			
			// Skip four bytes.
			s.readInt();
			
			locals[i].setIndex(s.readUnsignedShort());
		}
	}
}
