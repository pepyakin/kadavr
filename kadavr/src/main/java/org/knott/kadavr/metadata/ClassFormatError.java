/**
 *  ClassFormatError.java : IceBird project
 *  23:37:33 
 */
package org.knott.kadavr.metadata;

/**
 * @author sergey
 */
public final class ClassFormatError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 857808210807907819L;

	/**
	 * 
	 */
	public ClassFormatError() {
	}

	/**
	 * @param arg0
	 */
	public ClassFormatError(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ClassFormatError(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ClassFormatError(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
