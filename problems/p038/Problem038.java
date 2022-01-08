/**
 * 
 */
package problems;

import java.util.Arrays;

/**
 * Problem038.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Feb 17, 2015
 */
public class Problem038
{
	private static final char[] DIGIT = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	public static void run()
	{
		boolean notFound = true;
		
		// num can only be either 4-digit number or 1-digit number
		// because 2-digit num will produce 8-digit or 11-digit product-sum
		// and 3-digit num will produce 7-digit or 11-digit product-sum
		
		// Because example answer shown starts with 9,
		// We know that the largest possible answer must start with 9
		
		// when num = 4-digit number		
		for (int t = 9876; t >= 9123; t--)
		{
			String sum = "";
			for (int b = 1; sum.length() < 9; b++)
				sum += t*b;
			
			if (isPandigital(sum))
			{
				System.out.println(sum);
				notFound = false;
				return;
			}
		}
		
		// when num = 1-digit number (or, simply 9)
		if (notFound)
		{
			String sum = "";
			for (int b = 1; sum.length() < 9; b++)
				sum += 9*b;
			
			System.out.println(sum);
		}
	}
	
	
	public static boolean isPandigital(String n)
	{
		char[] c = n.toCharArray();
		Arrays.sort(c);
		return Arrays.equals(c, DIGIT);
	}
}



// Answer is 932718654
// Execution time is 5.01978 ms

