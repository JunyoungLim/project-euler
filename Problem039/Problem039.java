/**
 * 
 */
package problems;

/**
 * Problem039.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Feb 20, 2015
 */
public class Problem039
{
	private static final int LIMIT = 1000;
	private static int[] triplet = new int[LIMIT+1];
	
	public static void run()
	{
		int max = 0, maxCount = 0;
		
		// Euclid's formula
		// a = m^2 - n^2
		// b = 2mn
		// c = m^2 + n^2
		// where n < m, m and n are coprime, and m-n is odd
		// in order to have primitive Pythagorean triplets
		
		// perimeter = a + b + c = 2*m^2 + 2mn = 2m * (m + n) <= LIMIT = 1000
		// m * (m + n) <= 500
		// maximum m value is when n == 0
		// Therefore, m * (m + 0) = m^2 <= 500
		// m <= sqrt of 500
		
		for (int m = 2, end = (int)Math.sqrt(LIMIT/2); m <= end; m++)
		{
			for (int n = 1 + m%2; n < m; n+=2) // n < m, m-n is odd
			{
				if (gcd(m, n) != 1) continue; // m and n must be coprime
				
				int p = 2*m*(m+n); // primitive triplet perimeter
				for (int k = 1; p*k <= 1000; k++) // fill non-primitive triplets for given perimeter
					triplet[p*k]++;
			}
		}
		
		
		for (int i = 0; i < triplet.length; i++)
		{
			if (triplet[i] > maxCount)
			{
				maxCount = triplet[i];
				max = i;
			}
		}
		
		System.out.println(max);
	}
	
	
	public static int gcd(int a, int b)
	{
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
}



Answer is 840
Execution time is .777626 ms


