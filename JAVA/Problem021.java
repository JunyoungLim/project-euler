/**
 * 
 */
package problems;

/**
 * Problem021.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 31, 2014
 */
public class Problem021
{
	public static void run()
	{
		int sum = 0;
		for (int i = 1; i < 10000; i++)
			if (isAmicable(i)) sum += i;
		System.out.println(sum);

	}
	
	public static boolean isAmicable(int a)
	{
		int b = sumFactor(a);
		return (a != b) && (a == sumFactor(b));
	}
	
	public static int sumFactor(int n)
	{
		if (n == 0) return 0;
		int sum = 1;
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++)
		{
			if (n%i == 0) sum += i + n/i;
		}
		if (n == sqrt*sqrt) sum -= sqrt;
		return sum;
	}
}



Answer is 31626
Execution time is 8.740898 ms

