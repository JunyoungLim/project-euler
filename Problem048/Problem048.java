/**
 * 
 */
package problems;

/**
 * Problem048.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Apr 15, 2015
 */
public class Problem048
{
	public static void run()
	{
		long mod = 10000000000L;
		long ans = 0;
		
		for (int i = 1; i <= 1000; i++)
		{
			if (i % 10 == 0) continue;
			long num = i;
			for (int j = 1; j < i; j++)
			{
				num *= i;
				num %= mod;
			}
			ans += num;
		}
		System.out.println(ans%mod);
	}
}


Answer is 9110846700
Execution time is 14.175984 ms


