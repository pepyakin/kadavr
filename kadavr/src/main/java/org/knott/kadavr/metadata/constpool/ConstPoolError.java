/**
 *  ConstPoolError.java : IceBird project
 *  21:26:08 
 */
package org.knott.kadavr.metadata.constpool;

/**
 * @author sergey
 */
public class ConstPoolError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3864701537365116648L;

	/**
	 * 
	 */
	public ConstPoolError() {
	}

	/**
	 * @param arg0
	 */
	public ConstPoolError(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ConstPoolError(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ConstPoolError(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
