/**
 * 
 */
package problems;

/**
 * Problem003.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem003
{
	public static void run()
	{
		long d = 600851475143L;
		int i = 3; // skip 2 because d is not an even number
		for (int i=3; i < Math.sqrt(d); i+=2)
		{
			if (d%i == 0)
				while (d%i == 0) d /= i;
		}
		i--; // take out unnecessary increment of i at the end of the for-loop
		if (d == 1) System.out.println(i); // if processed d is in form of p^k where p = prime number and k = integer
		else System.out.println(d); // if processed d is the largest prime factor
		
		// The last if-else statement wasn't necessary for this specific problem
		// but including the if-else block make it a universal solution
		// that can be applied to any positive odd integer
		// In order to do make it universal to any whole number (both odd and even)
		// include division by 2 above the for-loop

	}

}


// Answer is 6857
// Execution time is 0.001826415 seconds

