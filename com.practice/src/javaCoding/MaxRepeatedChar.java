package javaCoding;

public class MaxRepeatedChar {

	public static void main(String[] args) {

		String str = "abbccc";
		int[] arr = new  int[127];
		
		for(int i=0; i<str.length(); i++)
		{
			arr[str.charAt(i)] = arr[str.charAt(i)] + 1;
		}
		
		int max = -1;
		char chr = ' ';
		for(int i=0; i<str.length(); i++)
		{
			if( max < arr[str.charAt(i)])
			{
				max = arr[str.charAt(i)];
				chr =str.charAt(i);
			}
		}
		
		System.out.println("Maximum repeated character is " +chr);

	}

}
