package smcs.battis.serialization;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

public class Serialization {

    public static void main(String[] args) {
	
	Vector<Integer> list = new Vector<Integer>();
	Vector<Integer> other;
	
	list.add(1);
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(5);
	list.add(8);
	
	System.out.println(list);
	
	try {
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    ObjectOutputStream out = new ObjectOutputStream(os);
	    out.writeObject(list);
	    String s = new String(os.toByteArray(), "UTF-8");
	    
	    System.out.println(s);

	    ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
	    ObjectInputStream in = new ObjectInputStream(is);
	    other = (Vector<Integer>) in.readObject();
	    
	    System.out.println(other);
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
