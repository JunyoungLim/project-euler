/**
 * 
 */
package problems;

/**
 * Problem002.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem002
{

	/**
	 * 
	 */
	private static final int LIMIT = 4000000;
	
	public static void run()
    {
        int f = 1;
        int s = 1;
        int fibo = 0;
        int sum = 0;
        while (fibo <= LIMIT)
        {
            fibo = f + s;
            if (fibo%2 == 0) sum += fibo;
            f = s;
            s = fibo;
        }
        System.out.println(sum);
    }

}


// Execution time is 0.000797755 seconds

