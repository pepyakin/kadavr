/**
 *  ConstMethod.java : IceBird project
 *  21:48:42 
 */
package org.knott.kadavr.metadata.constpool;

import java.util.ArrayList;

import org.knott.kadavr.metadata.BasicType;
import org.knott.kadavr.metadata.Method;

/**
 * @author sergey
 */
public class ConstMethod extends ConstMember {

	/**
	 * @param pool
	 * @param classID
	 * @param signID
	 */
	ConstMethod(ConstPool pool, int classID, int signID) {
		super(pool, classID, signID);
	}

	/* (non-Javadoc)
	 * @see icebird.metadata.constpool.ConstObject#getTag()
	 */
	public byte getTag() {
		return CONST_METHODREF;
	}
	
	/**
	 * Gets return type of method.
	 * @return BasicType
	 */
	public BasicType getReturnType() {
		String desc = getDescriptor();
		
		int id = desc.indexOf(')') + 1;
		return BasicType.parse(desc.substring(id));
	}
	
	/**
	 * Gets argument types of method.
	 * @return BasicType[]
	 */
	public BasicType[] getArguments() {
		ArrayList<BasicType> args = new ArrayList<BasicType>();
		String desc = getDescriptor();
		int i = desc.indexOf('(');
		
		while (desc.charAt(i) != ')') {
			if (desc.charAt(i) == '(') {
				i++;
				continue;
			}
			
			BasicType arg = BasicType.parse(desc.substring(i));
			args.add(arg);
			
			i += arg.toString().length();
		}
		
		return args.toArray(new BasicType[args.size()]);
	}
	
	/**
	 * Gets arguments count.
	 * @return int
	 */
	public int getArgumentCount() {
		return getArguments().length;
	}
	
	public final Method resolve() {
		return getConstClass().getClassDef().getMethod(this);
	}
}
