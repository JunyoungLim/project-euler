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
		System.out.println(d);

	}

}


// Execution time is 0.002033269 seconds
