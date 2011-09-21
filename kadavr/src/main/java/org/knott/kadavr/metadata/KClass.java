/**
 *  Class.java : IceBird project
 *  23:04:37 
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.knott.kadavr.metadata.constpool.ConstClass;
import org.knott.kadavr.metadata.constpool.ConstField;
import org.knott.kadavr.metadata.constpool.ConstMethod;
import org.knott.kadavr.metadata.constpool.ConstPool;

/**
 * @author sergey
 */
public class KClass {
	
	private static final String OBJECT = "java/lang/Object";
	
	private static int idc = 0;
	private int id = idc++;
	
	// Metadata.
	private ConstPool constPool;
	
	// Modifiers.
	private int modifiers;
	
	// This class data.
	private int thisClass;
	private int superClass;
	
	// Class data.
	private ConstClass[] interfaces;
	private Method[] methodTable;
	private Field[] fieldTable;
	private Attribute[] attributes;
	
	
	// Dont allow public access.
	private KClass() {
	}
	
	/**
	 * Gets this class ID.
	 * @return String
	 */
	public String getName() {
		return constPool.getConstClass(thisClass).getName();
	}
	
	/**
	 * Gets super class ID.
	 * @return String
	 */
	public String getSuperName() {
		if (getName().equals(OBJECT)) {
			return null;
		}
		
		return constPool.getConstClass(superClass).getName();
	}
	
	/**
	 * Gets super class.
	 * @return Class
	 */
	public KClass getSuperClass() {
		return org.knott.kadavr.ClassLoader.getClass(getSuperName());
                
	}
	
//	/**
//	 * Gets mangled name.
//	 * @return String
//	 */
//	public String getMangledName() {
//		String name = NameMangler.mangleClassName(getName());
//		return name;
//	}
	
//	/**
//	 * Gets string representation.
//	 */
//	public final String toString() {
//		return "_CL_" + getMangledName();
//	}
	
	/**
	 * Is this class is final?
	 * @return boolean
	 */
	public boolean isFinal() {
		return Modifier.isFinal(modifiers);
	}
	
	/**
	 * Is this class is public?
	 * @return boolean
	 */
	public boolean isPublic() {
		return Modifier.isPublic(modifiers);
	}
	
	/**
	 * Is this class is static?
	 * @return boolean
	 */
	public boolean isStatic() {
		return Modifier.isStatic(modifiers);
	}
	
	/**
	 * Is this class represents interface?
	 * @return boolean
	 */
	public boolean isInterface() {
		return Modifier.isInterface(modifiers);
	}
	
	/**
	 * Is this class represents enum?
	 * @return boolean
	 */
	public boolean isEnum() {
		return Modifier.isEnum(modifiers);
	}
	
	/**
	 * Is this class abstract?
	 * @return boolean
	 */
	public boolean isAbstract() {
		return Modifier.isAbstract(modifiers);
	}
	
	/**
	 * Is this type has finalizer(Other than java.lang.Object.finalize())
	 * @return boolean
	 */
	public boolean hasFinalizer() {
		return Modifier.isFinalizer(modifiers);
	}
	
	/**
	 * Gets access flags.
	 * @return int
	 */
	public int getAccessFlags() {
		return modifiers & 7; // 7 - access flags bit mask. 7 == 1 | 2 | 4
	}
	
	/**
	 * Gets class inheirtance length.
	 * @return int
	 */
	public int getSuperClassDepth() {
		if (getName().equals(OBJECT)) {
			return 1;
		}
		
		return getSuperClass().getSuperClassDepth() + 1;
	}
	
	/**
	 * Gets constant pool.
	 * @return ConstClass
	 */
	public ConstPool getConstPool() {
		return constPool;
	}
	
	/**
	 * @return the attributes
	 */
	public final Attribute[] getAttributes() {
		return attributes;
	}

	/**
	 * @return the fieldTable
	 */
	public final Field[] getFieldTable() {
		return fieldTable;
	}

	/**
	 * @return the methodTable
	 */
	public Method[] getMethodTable() {
		return methodTable;
	}

	/**
	 * @return the modifiers
	 */
	public final int getModifiers() {
		return modifiers;
	}

//	/**
//	 * @return the version
//	 */
//	public final Version getVersion() {
//		return version;
//	}
	
	/**
	 * 
	 * @param desc may be passed.
	 * @return Field
	 */
	public final Field getField(String name, String desc) {
		for (Field f : fieldTable) {
			if (f.getName().equals(name)) {
				if (desc != null && desc.equals(f.getDescriptor())) {
					return f;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Gets field by ConstField entry.
	 * @return Field
	 */
	public final Field getField(ConstField f) {
		return getField(
			f.getName(),
			f.getDescriptor()
		);
	}
	
	/**
	 * Find method.
	 * @return Method
	 */
	public final Method getMethod(ConstMethod method) { 
		return getMethod(
			method.getName(), 
			method.getDescriptor()
		);
	}
	
	/**
	 * Find method.
	 * @return Method
	 */
	public final Method getMethod(String name, String desc) {
		for (Method m : methodTable) {
			if (m.getName().equals(name)) { 
				if (m.getDescriptor().equals(desc)) return m;
			}
		}
		
		return null;
	}
	
	/**
	 * Return Type ID.
	 * @return int
	 */
	public final int getTID() {
		return id;
	}
	
//	/**
//	 * Gets fields(And their values) which content
//	 * is known at compile time.
//	 * @return HashMap<Field,ConstLocation>
//	 */
//	public final HashMap<Field, ConstLocation> getConstFields() {
//		if (consts != null) {
//			return consts;
//		}
//		
//		SpecialMethod init = (SpecialMethod)getMethod("<clinit>", "()V");
//		
//		// Must be static initializer. 
//		if (init == null) return null;
//		
//		ConstFieldFinder finder = new ConstFieldFinder();
//		BytecodeParser parser = new BytecodeParser(
//			new ByteCode(init),
//			finder
//		);
//		
//		parser.parse();
//		
//		consts = finder.getConstantFields();
//		return getConstFields();
//	}
	
//	/**
//	 * If specified field is have content which
//	 * content known at compile time.
//	 * @return boolean
//	 */
//	public final boolean isConstantField(Field f) {
//		ConstLocation l = getConstFields().get(f);
//		
//		return (l != null);
//	}

	/**
	 * Load class from data input stream.
	 * @return Class
	 */
	public static KClass loadClass(DataInputStream s) throws IOException {
		if (s.readInt() != 0xCAFEBABE) {
			throw new ClassFormatError();
		}
		
		KClass c = new KClass();
		
		int major = s.readUnsignedShort();
		int minor = s.readUnsignedShort();
		
		// Set bytecode version.
//		c.version = new Version(minor, major);
		
		// Read constant pool data.
		c.constPool = ConstPool.read(s);
		
		// Read modifiers.
		c.modifiers = s.readUnsignedShort();
		
		// Read class data.
		c.thisClass = s.readUnsignedShort();
		c.superClass = s.readUnsignedShort();
		
		// Read interfaces.
		int interfaceCount = s.readUnsignedShort();
		c.interfaces = new ConstClass[interfaceCount];
		
		for (int i = 0; i < interfaceCount; i++) {
			c.interfaces[i] = c.constPool.getConstClass(
				s.readUnsignedShort()
			);
		}
		
		// Read fields.
		int fieldCount = s.readUnsignedShort();
		c.fieldTable = new Field[fieldCount];
		
		for (int i = 0; i < fieldCount; i++) {
			c.fieldTable[i] = Field.fromStream(c, s);
		}
		
		// Read methods
		int methodCount = s.readUnsignedShort();
		c.methodTable = new Method[methodCount];
		
		for (int i = 0; i < methodCount; i++) {
			c.methodTable[i] = Method.fromStream(c, s);
		}
		
		// Read attributes.
		int attributeCount = s.readUnsignedShort();
		c.attributes = new Attribute[attributeCount];
		
		for (int i = 0; i < attributeCount; i++) {
			c.attributes[i] = Attribute.read(c, s);
		}
		
		return c;
	}
}
