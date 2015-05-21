/**
 * 
 */
package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem029.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 21, 2015
 */
public class Problem029
{
	public static void run()
	{
	    // Double can be used in this problem
	    // because we are not required to find exact values
	    // but find the total number of the values
	    // Double is precise enough to distinguish values : BigInteger is too heavy to be used for this problem
		Set<Double> list = new HashSet<Double>();
		
		for (int a = 2; a <= 100; a++)
		{
			for (int b = 2; b <= 100; b++)
			{
				list.add(Math.pow(a, b));
			}
		}
		System.out.println(list.size());
	}
}



// Answer is 9183
// Execution time is 0.008553895 seconds

