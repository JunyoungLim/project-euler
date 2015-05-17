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
		int i = 3;
		
		if (d%2 == 0) while (d%2 == 0) d /= 2;
		if (d == 1) i = 4;
		
		for ( ; i < Math.sqrt(d); i+=2)
		{
			if (d%i == 0)
				while (d%i == 0) d /= i;
		}
		i -=2 ; // take out unnecessary increment of i at the end of the for-loop
		if (d == 1) System.out.println(i); // if processed d is in form of p^k where p = prime number and k = integer
		else System.out.println(d); // if processed d is the largest prime factor
		
		// The if-statement for division by 2 at the beginning of this code
		// and the last if-else statement wasn't necessary for this specific problem
		// but including the if-else block make it a universal solution
		// that can be applied to any positive integer

	}

}


// Answer is 6857
// Execution time is 0.002068384 seconds

