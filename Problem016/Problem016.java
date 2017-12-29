/**
 * 
 */
package problems;

import java.math.BigInteger;

/**
 * Problem016.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 19, 2014
 */
public class Problem016
{
	public static void run()
	{
		int ans  = 0;
		BigInteger num = BigInteger.valueOf(2).pow(1000);
		char[] arr = num.toString().toCharArray();
		for (char c : arr) ans += c - '0';
		System.out.println(ans);
	}
}



Answer is 1366
Execution time is 2.681005 ms

