/**
 * 
 */
package problems;

/**
 * Problem035.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Feb 7, 2015
 */
public class Problem035
{
	private static final int LIMIT = 1000000;
	private static final boolean[] isPrime = primeList(LIMIT);
	
	public static void run()
	{
		int count = 0;
		
		if (isPrime[2] && isCirPrime(2)) count++;
		
		for (int i = 3; i < LIMIT; i+= 2)
			if (isPrime[i] && isCirPrime(i)) count++;
		
		System.out.println(count);
	}
	
	public static boolean isCirPrime(int n)
	{
		String num = String.valueOf(n);
		for (int i = 0; i < num.length() - 1; i++)
		{
			num = num.substring(1) + num.substring(0,1);
			if (!isPrime[Integer.parseInt(num)]) return false;
		}
		return true;
	}
	
	public static boolean[] primeList(int n)
    {
        //sieve of Eratosthenes
        boolean[] prime = new boolean[n+1];
        java.util.Arrays.fill(prime, 2, prime.length, true);
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



Answer is 55
Execution time is 0.051694621 seconds

