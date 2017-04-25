/**
 * 
 */
package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem041.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Feb 25, 2015
 */
public class Problem041
{
	private static final int LENGTH = 7;
	private static int[] fact = new int[10];
	private static final List<Integer> digit = new ArrayList<Integer>();
	
	public static void run()
	{
		// fill factorial array
		java.util.Arrays.fill(fact, 1);
		for (int i = 2; i < fact.length; i++)
			fact[i] = fact[i-1]*i;
		
		
		// possible candidates for n is 1 through 9
		// Keep in mind that for multiple of 3 or 9, the sum of the digits is multiple of 3 or 9
		
		// 1 is not possible because 1 itself is not prime
		// 2 is not possible because 1 + 2 = 3 multiple of 3
		// 3 is not possible because 1 + 2 + 3 = 6 multiple of 3
		// 5 is not possible because 1 + 2 + 3 + 4 + 5 = 15 multiple of 3
		// 6 is not possible because 1 + 2 + 3 + 4 + 5 + 6 = 21 multiple of 3
		// 8 is not possible because 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36 multiple of 9
		// 9 is not possible because 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45 multiple of 9
		
		// only possibility is n = 4 or 7
		// by simple investigation, we can easily find
		// that 1-2-3-4-6-5-7 is a smallest n = 7 pandigital prime number
		// (this number is 3rd smallest possible combination of n = 7 padigital number)
		// This proves that there is at least one possibility for n = 7
		// which means we don't need to investigate n = 4 anymore
		
		// We just need to check for n = 7 only
		
		fillDigitList();
		
		for (int i = fact[7] - 1; i >= 0; i--) // from largest to smallest
		{
			int p = generate(i); // generating algorithm is from Problem 24
			
			if (isPrime(p)) { System.out.println(p); break; } // once it is prime, then the num is largest && prime
			
			fillDigitList();
		}
	}
	
	
	// Generate nth pandigital number using 1 to 7
	public static int generate(int n)
	{
		String num = "";
		
		for (int i = 0; i < LENGTH; i++)
		{
			int fac = fact[LENGTH - i - 1];
			int div = n / fac;
			n %= fac;
			
			num += digit.get(div);
			digit.remove(div);
		}
		
		return Integer.parseInt(num);
	}
	
	
	// is it prime : specifically optimized for this problem; not universal solution
	public static boolean isPrime(int n)
	{
		if (n%2 == 0) return false;
		for (int i=3, end = (int)Math.sqrt(n); i <= end; i+=2)
		{
			if (n%i == 0) return false;
		}
		return true;
	}
	
	
	// fill necessary digits from 1 to 7
	public static void fillDigitList()
	{
		for (int i = 1; i <= LENGTH; i++) digit.add(i);
	}
}




Answer is 7652413
Execution time is 1.623937 ms

