/**
 * 
 */
package problems;

/**
 * Problem007.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 15, 2014
 */
public class Problem007
{
	private static final int TARGET = 10001;
	
	public static void run()
	{
		int count = 1, num = 0;
		for (int i=3; count != TARGET; i+=2)
		{
			if (isPrime(i)) count++;
			if (count == TARGET) num = i;
		}
		System.out.println(num);
	}
	
	public static boolean isPrime(int n)
	{
		if (n == 1) return false;
		if (n == 2) return true;
		else if (n%2 == 0) return false;
		for (int i=3, end = (int)Math.sqrt(n); i <= end; i+=2)
		{
			if (n%i == 0) return false;
		}
		return true;
	}
}



Answer is 104743
Execution time is 0.012449134 seconds
