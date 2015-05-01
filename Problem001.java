/**
 * 
 */
package problems;

/**
 * Problem001.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem001
{
	public static void run()
	{
		System.out.println(sumMultiple(3,999) + sumMultiple(5,999) - sumMultiple(15,999));
	}
	
	
	public static int sumMultiple(int divisor, int num)
	{
		int last = num/divisor;
    		int sum = (last*(last + 1))/2;
    		return sum*divisor;
	}
	
}


// Answer is 233168
// Execution time is 0.000803676 seconds


