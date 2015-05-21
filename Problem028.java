/**
 * 
 */
package problems;

/**
 * Problem028.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since May 20, 2015
 */
public class Problem028
{
	private static final int LEN = 1001;
	
	public static void run()
	{
		int sum = 1, currentNum = 1;
		
		for (int i = 1; i <= LEN/2; i++)
		{
			int incr = 2*i;
			for (int j = 0; j < 4; j++) // calculate all 4 sides
			{
				currentNum += incr;
				sum += currentNum;
			}
		}
		System.out.println(sum);
	}
}



// Answer is 669171001
// Execution time is 6.92364E-4 seconds

