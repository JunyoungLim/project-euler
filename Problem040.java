/**
 * 
 */
package problems;

/**
 * Problem040.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Feb 22, 2015
 */
public class Problem040
{
	private static final int LIMIT = 8;
	private static int[] totalDigit = new int[LIMIT]; // {0, 9, 189, ...} total digits under 10^n
	private static int[] totalNumber = new int[LIMIT]; // {0, 9, 99, 999, ...} total numbers under 10^n
	
	public static void run()
	{
		// fill the arrays first
		for (int i = 1; i < LIMIT; i++)
		{
			totalNumber[i] = totalNumber[i-1]*10 + 9;
			totalDigit[i] = i * (totalNumber[i] - totalNumber[i-1]) + totalDigit[i-1];
		}
		
		int prod = 1, n = 1;
		for (int i = 0; i < LIMIT-1; i++, n *= 10)
		{
			int num = n;
			int digit = 0;
			while (num > totalDigit[digit]) digit++;
			
			num -= totalDigit[digit-1];
			int quo = num / digit + totalNumber[digit-1];
			int rem = num % digit;
			
			if (rem == 0) prod *= quo % 10;
			else prod *= String.valueOf(quo + 1).charAt(rem - 1) - '0';
		}
		System.out.println(prod);
	}
}




Answer is 210
Execution time is 0.001826042 seconds

