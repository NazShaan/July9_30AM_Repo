package javaCoding;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkListDemo {

	

	public static void main(String[] args) {
		LinkedList<String> ll	 = new LinkedList<String>();
		ll.add("Black");
		ll.add("White");
		ll.add("Blue");
		ll.add("Orange");
		ll.add("Red");
		ll.add("Gray");
		
		
		System.out.println(ll.contains("Black"));
		String str = ll.get(2);
		System.out.println(str);
		ll.addLast("Brown");
		ll.addFirst("Yellow");
		
		Iterator<String> colors = ll.iterator();
		
		while(colors.hasNext())
		{
			System.out.println(colors.next());
		}
		System.out.println("**************");
	System.out.println(ll);
	
	LinkedList<String> copy = (LinkedList<String>) ll.clone();
	System.out.println(copy);
	
	//To add elements from arraylist
	
	List<String> al = new ArrayList<String>();
	al.add("Automn");
	al.add("Fall");
	
	copy.addAll(al);
	System.out.println(copy);
	al.addAll(ll);
	System.out.println(al);
	
	//creating another sublist from Linked list
	List<String> subList = ll.subList(2, 7);
	System.out.println("the new sublist of linked list is: "+subList);
	
	
	}

}
