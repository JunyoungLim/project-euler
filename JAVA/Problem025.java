/**
 * 
 */
package problems;

import java.math.BigInteger;

/**
 * Problem025.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 11, 2015
 */
public class Problem025
{
	private static final int DIGIT = 1000;
	private static final BigInteger LIMIT = BigInteger.TEN.pow(DIGIT-1);
	
	public static void run()
	{
		int index = 2; // f1 and f2
		BigInteger f1 = BigInteger.ONE, f2 = BigInteger.ONE;
		while (f2.compareTo(LIMIT) < 0)
		{
			BigInteger temp = f1.add(f2);
			f1 = f2;
			f2 = temp;
			index++;
		}
		System.out.println(index);
	}
}



Answer is 4782
Execution time is 5.803691 ms

