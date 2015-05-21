/**
 * 
 */
package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem024.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 5, 2015
 */
public class Problem024
{
	private static int OFF_ERROR = 1;
	private static int limit = 1000000 - OFF_ERROR; // off-by-one error : nth permutation == (n-1)th index
	private static final int LENGTH = 10;
	private static List<Integer> digit = fillDigitList(LENGTH);
	
	public static void run()
	{
		String num = "";
		
		for (int i=0; i < LENGTH; i++)
		{
			int fac = 1;
			for (int j=1; j <= LENGTH-i-1; j++) fac *= j;
			
			int div = limit/fac;
			limit %= fac;
			
			num += digit.get(div);
			digit.remove(div);
		}
		System.out.println(num);
	}
	
	//fill list of Integer that are available for permutation
	public static List<Integer> fillDigitList(int len)
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i < 10; i++) list.add(i);
		return list;
	}
}




// Answer is 2783915460
// Execution time is 8.696E-4 seconds

