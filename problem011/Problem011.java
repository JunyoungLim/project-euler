/**
 * 
 */
package Problem011;

import util.Utils;

/**
 * Problem011.java
 * @author Jared Junyoung Lim
 *
 * @version 1.00
 * @since Dec 17, 2014
 */
public class Problem011
{
	private static final int N = 20;

	public static void main(String[] args)
	{
		int[][] grid = Utils.readMatrix(N, Problem011.class.getResource("grid.txt"));
		int limit = grid.length-3;
		int hor=0, ver=0, dia1=0, dia2 =0;
		
		// check horizontal and vertical products
		for (int i=0; i < grid.length; i++)
		{
			int h, v;
			for (int j=0; j < limit; j++)
			{
				h = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
				v = grid[j][i] * grid[j+1][i] * grid[j+2][i] * grid[j+3][i];
				if (h > hor) hor = h;
				if (v > ver) ver = v;
			}
		}
		
		// check diagonal products (both \ and / )
		for (int i=0; i < limit; i++)
		{
			int d1, d2;
			for (int j=0; j < limit; j++)
			{
				d1 = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
				d2 = grid[i][j+3] * grid[i+1][j+2] * grid[i+2][j+1] * grid[i+3][j];
				if (d1 > dia1) dia1 = d1;
				if (d2 > dia2) dia2 = d2;
			}
		}
		System.out.println(Math.max(Math.max(hor, ver), Math.max(dia1, dia2)));
	}
}