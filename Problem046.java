/**
 * 
 */
package problems;

/**
 * Problem046.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Mar 24, 2015
 */
public class Problem046
{
	private static boolean[][] isPrime = new boolean[2][100];
	
	public static void run()
	{
		for (int i = 35; ; i+=2)
		{
			if (!isGoldbach(i))
			{
				System.out.println(i);
				break;
			}
		}
	}
	
	public static boolean isGoldbach(int n)
	{
		if (isPrime(n)) return true;
		else
		{
			for (int i = 1, end = (int)Math.sqrt(n/2); i <= end; i++)
			{
				if (isPrime(n - 2*i*i)) return true;
			}
		}
		return false;
	}
	
	public static boolean isPrime(int n)
	{
		if (n >= isPrime[0].length)
		{
			boolean[][] temp = new boolean[2][isPrime[0].length*10];
			System.arraycopy(isPrime[0], 0, temp[0], 0, isPrime[0].length);
			System.arraycopy(isPrime[1], 0, temp[1], 0, isPrime[1].length);
			isPrime = temp;
		}
		if (isPrime[1][n]) return isPrime[0][n];
		else
		{
			isPrime[0][n] = isP(n);
			isPrime[1][n] = true;
			return isPrime[0][n];
		}
	}
	
	public static boolean isP(int n)
	{
		for (int i = 3, end = (int)Math.sqrt(n); i <= end; i+=2)
		{
			if (n % i == 0) return false;
		}
		return true;
	}
}


5777
Execution time is 1.894309 ms



