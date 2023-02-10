package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *This class contains utility methods for serialisation
 */
//
public class Serialization {
	/**
	 *This method reads the serialized object from the file with a given fileName
	 *for the file containing the serialized object to be read
	 * @param fileName
	 * @return
	 */
	//
	//
	public static Object readSerializedObject(String fileName) {
		Object obj = null;
		
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			
			obj = in.readObject();
			
			in.close();
			file.close();
			
		} catch (EOFException e) {
            return null;
            
        } catch (IOException ex) {
			ex.printStackTrace();
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/**
		 *Returns the serialized object when founds
		 */
		//
		return obj;
	}

	/**
	 *This method writes the serialized object to the file, given the object and a fileName for it
	 * @param fileName
	 * @param obj
	 */
	//
	public static void writeSerializedObject(String fileName, Object obj) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(obj);
			
			out.close();
			file.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
