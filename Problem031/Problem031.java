/**
 * 
 */
package problems;

/**
 * Problem031.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jul 6, 2015
 */
public class Problem031
{
	private static final int BUDGET = 200;
	private static final int[] COIN = {0, 1, 2, 5, 10, 20, 50, 100, 200};
	private static int[][] ways = new int[COIN.length][BUDGET + 1];
	
	public static void main(String[] args)
	{
		ways[0][0] = 1;
		for (int i = 1; i < COIN.length; i++)
			for (int j = 0; j <= BUDGET; j++)
				ways[i][j] = ways[i - 1][j] + (j < COIN[i] ? 0 : ways[i][j - COIN[i]]);
		System.out.println(ways[ways.length - 1][ways[0].length - 1]);
	}
}


Answer is 73682
Execution time is 0.328022 ms


