/**
 * 
 */
package problems;

/**
 * Problem004.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem004
{
	public static void run()
	{
		int ans = 0;
		for (int i = 999; i >= Math.sqrt(ans); i--)
		{
			for (int j = i; j >= 100; j--)
			{
				int temp = i*j;
				if (temp < ans) break;
				else if (isPalin(String.valueOf(temp))) ans = temp;
			}
		}
		System.out.println(ans);
	}
	
	
	public static boolean isPalin(String n)
	{
		return (new StringBuffer(n).reverse().toString().equals(n));
	}

}


// Answer is 906609
// Execution time is 6.572671 ms

