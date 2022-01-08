/**
 * 
 */
package problems;

/**
 * Problem023.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Jul 5, 2015
 */
public class Problem023
{
	private static final int LIMIT = 28123;
	private static boolean[] isAbundant = sieveAbundance(LIMIT);
	
	public static void run()
	{
		int sum = 0;
		for (int i = 1; i <= LIMIT; i++)
		{
			if (!isSumOfTwoAbundant(i)) sum += i;
		}
		System.out.println(sum);
	}
	
	public static boolean isSumOfTwoAbundant(int n)
	{
		for (int i = n / 2; i >= 12; i--)
			if (isAbundant[i] && isAbundant[n - i]) return true;
		return false;
	}
	
	public static boolean isAbundant(int n)
	{
		int original = n;
		int sum = 1;
		
		if (n % 2 == 0)
		{
			int temp = 1;
			for (int mult = 2; n % 2 == 0; n /= 2, mult *= 2)
				temp += mult;
			sum *= temp;
		}
		for (int i = 3, end = (int)Math.sqrt(n); i <= end; i += 2)
		{
			if (n % i == 0)
			{
				int temp = 1;
				for (int mult = i; n % i == 0; n /= i, mult *= i)
					temp += mult;
				sum *= temp;
				end = (int)Math.sqrt(n);
			}
		}
		if (n != 1) sum *= 1 + n;
		return original + original < sum;
	}
	
	public static boolean[] sieveAbundance(int limit)
	{
		boolean[] abun = new boolean[limit + 1];
		for (int i = 12; i <= limit; i++)
		{
			if (!abun[i])
			{
				if (abun[i] = isAbundant(i))
				{
					for (int j = i; j <= limit; j += i)
						abun[j] = true;
				}
			}
		}
		return abun;
	}
}


// Answer is 4179871
// Execution time is 28.948803 ms


