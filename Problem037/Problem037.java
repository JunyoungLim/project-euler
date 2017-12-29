/**
 * 
 */
package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem037.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jul 12, 2015
 */
public class Problem037
{
	private static final int[] DIGIT = {1, 3, 7, 9};
	
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(7);
		
		int sum = 23 + 53;
		
		for (int pow = 10, start = 0, count = 2, end = 2; count < 11; start = end, end = list.size(), pow *= 10)
		{
			for (int i = start; i < end; i++)
			{
				for (int dig : DIGIT)
				{
					int num = dig * pow + list.get(i);
					if (isPrime(num))
					{
						list.add(num);
						if (isRTP(num / 10))
						{
							sum += num;
							count++;
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
	
	public static boolean isRTP(int n)
	{
		while (n > 0)
		{
			if (!isPrime(n)) return false;
			n /= 10;
		}
		return true;
	}
	
	public static boolean isPrime(int n)
	{
		if (n <= 3) return n > 1;
		else if (n % 2 == 0 || n % 3 == 0) return false;
		for (int i = 5, end = (int)Math.sqrt(n); i <= end; i += 6)
		{
			if (n % i == 0 || n % (i + 2) == 0) return false;
		}
		return true;
	}
}


Answer is 748317
Execution time is 0.242759 ms



