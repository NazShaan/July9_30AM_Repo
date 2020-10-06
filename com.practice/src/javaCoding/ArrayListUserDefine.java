/*Write a program to implement your own ArrayList class. It should
contain add(), get(), remove(), size() methods. Use dynamic array logic.
It should increase its size when it reaches threshold. 
 */


package javaCoding;

import java.util.Arrays;

public class ArrayListUserDefine {
	
	private Object[] obj = null;
	static int actSize =0;
	
	public ArrayListUserDefine()
	{
		obj = new Object[10];
	}
	
	
	public Object getData(int index)
	{
		if(index < actSize)
		{
			return obj[index];
		}
		else
			throw new ArrayIndexOutOfBoundsException();
		
		
	}
	
	public void addData(Object value)
	{
		if(obj.length-actSize <5) // increase its size when it reached its thredholds.
		{
			reSizeArray();
		
		}
		
		else
			obj[actSize++] = value;
		
	}
	
	
	public void reSizeArray() 
	{
		obj = Arrays.copyOf(obj, obj.length*2);	//increase the size of array.
		System.out.println("\n the new size of arrays :"+obj.length);
	}
	
	public void removeData(Object del_obj)
	{
		int count=0;
		for(int i=0; i<obj.length; i++) 
		{
			if(obj[i]==del_obj)
			{
				for(int j=i; j<obj.length-1; j++) // j loop starting from i,
				{
					obj[j] =obj[j+1];
					
				}
				count++;
				break;
				
			}
		}
		actSize--;
		
		if(count==0)
		{
			System.out.println("\n given element is not found. ");
		}
		else
		{
			System.out.println("\n Element deleted successfully....");
			
		}
	}
	
	public int size()
	{
		//System.out.println("The size of array is :"+actSize);
		return actSize;
	}
	
	public void getAllElements()
	{
		for(int i=0; i<actSize; i++)
		{
			System.out.print(obj[i]+ ", ");
		}
	}
	


	public static void main(String[] args) 
	{
		ArrayListUserDefine ald = new ArrayListUserDefine();
		ald.addData("Hello");
		ald.addData("World");
		ald.addData(100);
		ald.addData(10.50);
		
		System.out.println(ald.size());
		
		ald.getAllElements();
		ald.removeData(100);
		ald.size();
		ald.getAllElements();
	}

}
