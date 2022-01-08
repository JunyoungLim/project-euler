/**
 * 
 */
package problems;

import java.math.BigInteger;

/**
 * Problem020.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 27, 2014
 */
public class Problem020
{
	public static void run()
	{
		int ans = 0;
		BigInteger num = BigInteger.ONE;
		for (int i=1; i <= 100; i++) num = num.multiply(BigInteger.valueOf(i));
		
		char[] arr = num.toString().toCharArray();
		for (char c : arr) ans += c - '0';
		
		System.out.println(ans);

	}

}




// Answer is 648
// Execution time is 2.634032 ms

