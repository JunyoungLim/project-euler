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
		
		if (d == 1) System.out.println(i); // if the remaining number is in form of p^k where p = prime number and k = integer
		else System.out.println(d); // if the remaining number is the largest prime factor

	}

}


// Answer is 6857
// Execution time is 0.001826415 seconds

