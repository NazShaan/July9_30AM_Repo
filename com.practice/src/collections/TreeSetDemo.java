package collections;

import java.util.Set;
import java.util.TreeMap;

public class TreeSetDemo {

	public static void main(String[] args) 
	{
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(1, "Nuraz");
		tm.put(2, "Nabiha");
		tm.put(3, "Nazrul");
		tm.put(4, "Ayman");
		
		Set<Integer> keys = tm.keySet();
		for(int key : keys)
		{
			System.out.println(tm.get(key));
		}
		
		TreeMap <Integer, Object[]> emp = new TreeMap<Integer, Object[]>();
		emp.put(1, new Object[] {"shaan", "nazrul", "Nuraz", "Nabiha", 929351});
		emp.put(2, new Object[] {"Sylhet", "Dhaka", "Barisal", "Khulna", "Chittagonj", "Rajshahi"});
		emp.put(3, new Object[] {"Black", "Blue", "Yellow", "Green", "Brown"});
		
		Set<Integer> kys = emp.keySet();
		for(Integer ky: kys)
		{
			Object objArr[] = emp.get(ky);
			for(Object k : objArr)
			{
			System.out.print(k +"  ");
			
			}
			System.out.println();
		}
		
		

	}

}
