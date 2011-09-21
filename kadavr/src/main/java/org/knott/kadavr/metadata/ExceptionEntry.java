/**
 *  ExceptionEntry.java : IceBird project
 *  0:45:03 
 */
package org.knott.kadavr.metadata;

import org.knott.kadavr.metadata.constpool.ConstClass;
import org.knott.kadavr.metadata.constpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Represents exception entry.
 * @author sergey
 */
public final class ExceptionEntry {

    private int startPC;
    private int endPC;
    private int handlerPC;
    private int catchType;
    
    private KClass owner;
    
    ExceptionEntry(KClass onwer, DataInputStream s) throws IOException {
		startPC = s.readUnsignedShort();
		endPC = s.readUnsignedShort();
		
		handlerPC = s.readUnsignedShort();
		catchType = s.readUnsignedShort();
		
		this.owner = onwer;
	}
    
    /**
     * Is this exception entry represnts finally block.
     * @return boolean
     */
    public boolean isFinally() {
    	return catchType == 0;
    }
    
    /**
     * Gets constant pool.
     * @return ConstPool
     */
    private ConstPool getConstPool() {
    	return owner.getConstPool();
    }
    
    /**
     * Gets exception class.
     * @return ConstClass
     */
    public ConstClass getExceptionClass() {
    	if (isFinally()) {
    		throw new IllegalStateException("Finally blocks cannot catch any exception");
    	}
    	
    	return getConstPool().getConstClass(catchType);
    }

	/**
	 * @return the catchType
	 */
	public final int getCatchType() {
		return catchType;
	}

	/**
	 * @return the endPC
	 */
	public final int getEndPC() {
		return endPC;
	}

	/**
	 * @return the handlerPC
	 */
	public final int getHandlerPC() {
		return handlerPC;
	}

	/**
	 * @return the startPC
	 */
	public final int getStartPC() {
		return startPC;
	}
}
