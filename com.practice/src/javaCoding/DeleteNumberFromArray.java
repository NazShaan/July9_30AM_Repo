package javaCoding;

public class DeleteNumberFromArray {
	public static void main (String[] args)
	{
		int[] numbers = {10,20,30,40,50,60};
		int delNum = 50;
		int arrSize=numbers.length;

		for(int i=0; i<numbers.length; i++)
		{
		  if( numbers[i]==delNum)
			{
			for(int j=i; j<numbers.length-1; j++)
				{
					numbers[j] = numbers[j+1]; 	
				}	
			break;
			}
			
			
		}
		arrSize--;
		for(int k=0; k<arrSize; k++)
		{
			System.out.print(numbers[k]+"  ");
			System.out.println();
			
		}
		
		numbers = new int[arrSize];
		System.out.println("the length of array " +numbers.length);	
	}


}
