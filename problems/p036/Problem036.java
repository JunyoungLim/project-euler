/**
 * 
 */
package problems;

/**
 * Problem036.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Feb 11, 2015
 */
public class Problem036
{
	private static final int LIMIT = 1000;
	private static int sum = 0;
	
	public static void run()
	{
		for (int i = 1; i < LIMIT; i++)
			checkPalindromePair(i);
		
		System.out.println(sum);
	}
	
	public static boolean isPalindrome(String n)
	{
		return new StringBuffer(n).reverse().toString().equals(n);
	}
	
	public static void checkPalindromePair(int num)
	{
		int p1 = num, p2 = num*10 + num%10; // two palindromic numbers one with odd number of digits and other with even
		int n1 = num/10, n2 = num/10;
		
		while (n1 > 0)
		{
			p1 = p1*10 + n1%10;
			p2 = p2*10 + n2%10;
			n1 /= 10;
			n2 /= 10;
		}
		
		if (isPalindrome(Integer.toString(p1, 2))) sum += p1;
		if (isPalindrome(Integer.toString(p2, 2))) sum += p2;
	}
}



// Answer is 872187
// Execution time is 7.241036 ms

