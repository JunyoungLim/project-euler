/**
 * 
 */
package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem032.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 27, 2015
 */
public class Problem032
{
	private static final int LOWER = 2468;
	private static final int UPPER = 9876;
	private static final char[] DIGIT = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	public static void run()
	{
		Set<Integer> set = new HashSet<Integer>();
		
		int sum = 0;
		
		for (int n = 2; n <= 98; n++)
		{
			for (int m = LOWER/n, end = UPPER/n; m <= end; m++)
			{
				int nm = n*m;
				if (isPandigital("" + n + m + nm)) set.add(nm);
			}
		}
		
		for (int i : set) sum += i;
		System.out.println(sum);
	}
	
	public static boolean isPandigital(String n)
	{
		char[] c = n.toCharArray();
		Arrays.sort(c);
		return Arrays.equals(c, DIGIT);
	}
}



Answer is 45228
Execution time is 0.019576457 seconds

