package edu.uniasselvi.ads24.bob.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	
	public static String Serialize(Object o) {
		
		try {
		    ByteArrayOutputStream bo = new ByteArrayOutputStream();
		    ObjectOutputStream so = new ObjectOutputStream(bo);
		    so.writeObject(o);
		    so.flush();
		    return bo.toString();
		} catch (Exception e) {
		    System.out.println(e + " - " + e.getMessage());
		    System.exit(1);
		}
		return null;
	}
	
	public static Object Deserialize(String s) {
		
		try {
		    byte b[] = s.getBytes(); 
		    ByteArrayInputStream bi = new ByteArrayInputStream(b);
		    ObjectInputStream si = new ObjectInputStream(bi);
		    return si.readObject();
		} catch (Exception e) {
		    System.out.println(e + " - " + e.getMessage());
		    System.exit(1);
		}
		return null;
	}
}