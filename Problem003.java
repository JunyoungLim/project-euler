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
		for (int i=3; i < Math.sqrt(d); i+=2)
		{
			if (d%i == 0)
				while (d%i == 0) d /= i;
		}
		int sqrt = (int)Math.sqrt(d);
		if (d == sqrt*sqrt) System.out.println(sqrt);
		System.out.println(d);

	}

}


// Answer is 6857
// Execution time is 7.68934E-4 seconds

