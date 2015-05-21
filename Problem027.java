/**
 * 
 */
package problems;

import java.util.Arrays;

/**
 * Problem027.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 20, 2015
 */
public class Problem027
{
	private static final int LIMIT = 1000;
	private static final boolean[] isPrime = primeList(LIMIT); // all b's must be prime at least
	
	public static void run()
	{
		int max = 0, prod = 0;
		
		for (int b = 3; b < LIMIT; b+=2) // exclusion of b = 2
		{
			if (isPrime[b])
			{
				for (int a = -b; a < LIMIT; a+=2) // a = -b : quadratic num is always (+), a+=2 : num is odd
				{
					int temp = maxPrime(a,b);
					if (temp > max)
					{
						max = temp;
						prod = a*b;
					}
				}
			}
		}
		System.out.println(prod);
	}
	
	// count maximum consecutive quadratic prime number
	public static int maxPrime(int a, int b)
	{
		int n = 1; // when n = 0, the number is b which is already prime; so start with n = 1 and num = n*n + a*n + b
		for (int num = b; isPrime(num); n++)
			num = n*(n + a) + b; // n*n + a*n + b
		return n;
	}
	
	
	
	
	// if the number is prime number
	public static boolean isPrime(int n)
	{
		if (n <= 1) return false;
		else if (n%2 == 0) return false;
		for (int i=3, end = (int)Math.sqrt(n); i <= end; i+=2)
		{
			if (n%i == 0) return false;
		}
		return true;
	}
	
	
	
	
	//sieve of Eratosthenes
	public static boolean[] primeList(int n)
	{
	        boolean[] prime = new boolean[n+1];
	        Arrays.fill(prime, 2, prime.length, true);
	        for (int i=4; i < prime.length; i+=2) prime[i] = false;
	        for (int i=3, end = (int)Math.sqrt(n); i <= end; i+=2)
	        {
	            if (prime[i])
	                for (int j=i*i; j <= n; j+=2*i)
	                    prime[j] = false;
	        }
        	return prime;
	}
}



// Answer is -59231
// Execution time is 0.02057711 seconds

