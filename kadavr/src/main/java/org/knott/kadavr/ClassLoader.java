/**
 *  ClassLoader.java : IceBird project
 *  23:17:53 
 */
package org.knott.kadavr;

import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;

import org.knott.kadavr.metadata.KClass;

/**
 * Represents class dispatcher.
 * Avoids multiply loading(and verifing) of same classes.
 * @author sergey
 */
public final class ClassLoader {
	
	private static ArrayList<KClass> loaded;
	
	static {
		loaded = new ArrayList<KClass>();
	}
	
	/**
	 * Gets class by its classname.
	 * @return void
	 */
	public static final KClass getClass(String className) {		
		if (isLoaded(className)) {
			return getLoaded(className);
		} else {
			return loadClass(className);
		}
	}
	
	/**
	 * Checks, is class loaded?
	 * @return boolean
	 */
	private static boolean isLoaded(String className) {
		for (Iterator<KClass> iter = loaded.iterator(); iter.hasNext();) {
			KClass element = (KClass) iter.next();
			
			if (element.getName().equals(className)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Gets already loaded class.
	 * @return Class
	 */
	private static KClass getLoaded(String className) {
		for (Iterator<KClass> iter = loaded.iterator(); iter.hasNext();) {
			KClass element = (KClass) iter.next();
			
			if (element.getName().equals(className)) {
				return element;
			}
		}
		
		return null;
	}
	
	/**
	 * Load class.
	 * @return Class
	 */
	public static KClass loadClass(String className) {
		className = className.concat(".class");
		
		try {
			KClass c = KClass.loadClass(
				new DataInputStream(new FileInputStream(className))
			);
			
                        if (getLoaded(c.getName()) == null) {
                            loaded.add(c);
                        }
			
			
			return c;
		} catch (FileNotFoundException e) { 
			throw new RuntimeException("Class file cant be readed: File not found.");
		} catch (IOException e) {
			throw new RuntimeException("Class file cant be readed: I/O Error.");
		}
	}
}
