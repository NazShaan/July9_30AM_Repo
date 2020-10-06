package javaCoding;

public class FindMaxMinVal {

	public static void main(String[] args) 
	{
		int[] nos = {20,34,21,32,12,90};
		int[] max = new int[nos.length];
		int[] min = new int[nos.length];
		for(int i=0; i<nos.length; i++)
		{
			for(int j=i+1; j<nos.length; j++)
			{
				if(nos[i]>nos[j])   // Simply by changing < or > 
				{
					int temp = nos[j];
					nos[j]=nos[i];
					nos[i]=temp;
					
				}
			}
		}
		
		System.out.println("the minimum no to max no is  :");
		for(int k=0; k<nos.length; k++)
		{
			
			min[k] = nos[k];
		
			System.out.print(min[k]+"  ");
		}
		
		// to find the second largest number...
		System.out.println("the second largest number is : "+min[min.length-2]);

	}

}
