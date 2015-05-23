/**
 * 
 */
package problems;

/**
 * Problem026.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 15, 2015
 */
public class Problem026
{
	private static final int LIMIT = 1000;
	
	public static void run()
	{
		int seqLen = 0, num = 0;
		
		for (int i=LIMIT-1; i > seqLen; i-=2)
		{
			int rem = 10%i, mod = rem*rem%i;
			int count = 1;
			
			if (mod != rem)
			{
				while (mod != rem)
				{
					mod = mod*rem%i;
					count++;
				}
				
				if (count > seqLen)
				{
					seqLen = count;
					num = i;
				}
			}
		}
		System.out.println(num);
	}
}



Answer is 983
Execution time is 7.71709E-4 seconds

