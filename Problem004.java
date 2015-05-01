/**
 * 
 */
package problems;

/**
 * Problem004.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem004
{
	public static void run()
	{
		int ans = 0;
		for (int i = 100; i < 1000; i++)
		{
			for (int j = i; j < 1000; j++)
			{
				int temp = i*j;
				if (temp > ans && isPalin(""+temp)) ans = temp;
				
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
// Execution time is 0.020624791 seconds

