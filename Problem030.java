/**
 * 
 */
package problems;

/**
 * Problem030.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 24, 2015
 */
public class Problem030
{
	private static final int LIMIT = 6 * ((int)Math.pow(9, 5)); // 6*9^5 < 999999 : impossible further
	
	public static void run()
	{
		int sum = 0;
		for (int i = 2; i < LIMIT; i++)
			if (isSumFifthPower(i)) sum += i;
		System.out.println(sum);

	}
	
	public static boolean isSumFifthPower(int n)
	{
		int temp = n, sum = 0;
		while (n > 0)
		{
			int e = n%10;
			sum += e*e*e*e*e;
			n /= 10;
		}
		return temp == sum;
	}
}



// Answer is 443839
// Execution time is 0.031654541 seconds

