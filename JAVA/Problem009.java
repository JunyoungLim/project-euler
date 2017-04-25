/**
 * 
 */
package problems;

/**
 * Problem009.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 16, 2014
 */
public class Problem009
{
	public static void run()
	{
		for (int a=1, end = 1000/3; a < end; a++)
		{
			for (int b=a, end2 = 1000/2; b < end2; b++)
			{
				int c = 1000-a-b;
				if (c>0 && a*a + b*b == c*c)
				{
					System.out.println(a*b*c);
					return;
				}
			}
		}
	}
}


Answer is 31875000
Execution time is 1.722996 ms


