/**
 * 
 */
package problems;

/**
 * Problem047.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Mar 31, 2015
 */
public class Problem047
{
	public static void run()
	{
		for (int i = 647; ; i++)
		{
			if (!has4Prime(i))
			{
				if (!has4Prime(i + 4))
				{
					i += 4;
					continue;
				}
			}
			else
			{
				if (has4Prime(i + 1))
				{
					if (has4Prime(i + 2))
					{
						if (has4Prime(i + 3))
						{
							System.out.println(i);
							break;
						}
						i += 3;
					}
					i += 2;
				}
				i++;
			}
		}

	}
	
	public static boolean has4Prime(int n)
	{
		int count = 0;
		if (n % 2 == 0)
		{
			do n /= 2;
			while (n % 2 == 0);
			count++;
		}
		if (n % 3 == 0)
		{
			do n /= 3;
			while (n % 3 == 0);
			count++;
		}
		for (int i = 5; i <= Math.sqrt(n); i += 4)
		{
			if (n % i == 0)
			{
				do n /= i;
				while (n % i == 0);
				count++;
			}
			i += 2;
			if (n % i == 0)
			{
				do n /= i;
				while (n % i == 0);
				count++;
			}
		}
		if (n > 1) count++;
		return count == 4;
	}

}


Answer is 134043
Execution time is 28.291475 ms


