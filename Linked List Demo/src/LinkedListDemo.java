
import java.util.*;

public class LinkedListDemo {

    public static void main(String[] args) {
	LinkedList<String> queue;
	String active;
	
	queue = new LinkedList<String>();
	
	queue.add("A");
	queue.add("B");
	queue.add("C");
	queue.add("D");
	
	System.out.println ("Round 1: " + queue);
	
	active = queue.remove(); // dequeue active tank
	
	System.out.println ("Active: " + active);
	System.out.println (active + " fires and kills D");

	queue.remove(2); // this is a CHEAT, we would have a reference to a specific tank!!
	queue.add(active); // enqueue active tank
	
	System.out.println("Round 2: " + queue);
	
	active = queue.remove();
	
	System.out.println ("Active: " + active);
	System.out.println (active + " fires and kills B");

	// queue.remove(2); // this is a CHEAT, we would have a reference to a specific tank!!
	// queue.add(active);

	System.out.println("Round 3: " + queue);
	active = queue.remove();
	
	System.out.println ("Active: " + active);
	System.out.println (active + " fires and misses");
	queue.add(active); // enqueue active tank

	System.out.println ("Game over if queue contains 1: contains " + queue.size());

    }

}
