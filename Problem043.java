/**
 * 
 */
package problems;

import java.util.Arrays;

/**
 * Problem043.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Mar 3, 2015
 */
public class Problem043
{
	private static int[] prime = {2, 3, 5, 7, 11, 13, 17}; // primes that we need to check
	private static boolean[] available = new boolean[10]; // availability of each digit
	private static long sum = 0;
	
	public static void run()
	{
		for (int i = prime[6]; i < 1000; i += 17)
		{
			int a = i % 10, b = (i / 10) % 10;
			if (a == b) continue;
			
			Arrays.fill(available, true);
			available[a] = false;
			available[b] = false;
			
			String num = "" + i;
			
			if (i < 100) num = "0" + num;
			else
			{
				int c = i / 100;
				if (a == c || b == c) continue;
				available[c] = false;
			}
			
			goNext(num, 5);
		}
		System.out.println(sum);
	}
	
	
	// go to next step ( 17 - 13 - 11 - 7 - 5 - 3 - 2 )
	public static void goNext(String s, int p)
	{		
		String num;
		int n = prime[p];
		
		if (p == 0)
		{
			if ((s.charAt(1) - '0') % n == 0)
			{
				int a = 0;
				for (int i = 0; i < available.length; i++)
					if (available[i]) a = a* 10 + i;
				
				sum += Long.parseLong(a + s);
				sum += Long.parseLong(a%10 + "" + a/10 + s);
			}
		}
		else if (p == 4)
		{
			if (available[5]) // because d6 cannot be zero, only choice available is 5
			{                 // if d6 is 0, then d6d7d8 will be 011, 022, ... (multiple of 11) which isn't pandigital
				num = "5" + s;
				available[5] = false;
				if (Integer.parseInt(num.substring(0,3)) % n == 0) goNext(num, p - 1);
			}
		}
		else
		{
			for (int i = 0; i <= 9; i++)
			{
				if (available[i])
				{
					num = i + s;
					available[i] = false;
					if (Integer.parseInt(num.substring(0,3)) % n == 0) goNext(num, p - 1);
					available[i] = true;
				}
			}
		}
	}

}



Answre is 16695334890
Execution time is 3.355216 ms

