/**
 * 
 */
package problems;

/**
 * Problem050.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since May 24, 2015
 */
public class Problem050
{
	private static final int LIMIT = 1000000;
	private static final boolean[] isPrime = primeList(LIMIT);
	private static final int[] primeSum = primeSum();
	
	public static void run()
	{
		int seq = 0, num = 0;
		for (int i=0; i < primeSum.length - seq; i++)
		{
			for (int j = i + seq; j < primeSum.length; j++)
			{
				int temp = primeSum[j] - primeSum[i];
				if (temp > LIMIT) break;
				if (isPrime[temp] && j - i > seq)
				{
					num = temp;
					seq = j - i;
				}
			}
		}
		System.out.println(num);

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
    
    public static int[] primeSum()
    {
    	int length = 0;
    	for (boolean b : isPrime) if (b) length++;
    	int[] prime = new int[length];
    	prime[0] = 2;
    	for (int i=3, index = 1; i < isPrime.length; i+=2)
    	{
    		if (isPrime[i])
    		{
    			prime[index] = prime[index-1] + i;
    			index++;
    		}
    	}
    	return prime;
    }
}


Answer is 997651
Execution time is 15.181366 ms


