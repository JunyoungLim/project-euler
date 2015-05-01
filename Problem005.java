/**
 * 
 */
package problems;

/**
 * Problem005.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem005
{
	public static void run()
	{
		long ans = 1;
		for (int i=2; i <= 20; i++)
			ans = lcm(ans, i);
		System.out.println(ans);
	}
	
	public static long gcd(long a, long b)
	{
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
	
	public static long lcm(long a, long b)
	{
		return a*b/gcd(a,b);
	}
}


// Answer is 232792560
// Execution time is 0.002087348 seconds
