/**
 * 
 */
package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem011.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 17, 2014
 */
public class Problem011 implements textFile.Texts // all file paths are stored
{
	private static final int[][] grid = read();
	
	public static void run()
	{		
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
	
	
	
	
	
	
	
	// String "text011" is stored in Texts interface - the path name depends on where you store the file in computer
	// read in the text file containing 20 X 20 grid
	public static int[][] read()
	{
		int[][] text = new int[20][20];
		File file = new File(text011);
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			for (int i=0; (line = br.readLine()) != null; i++)
			{
				String[] temp = line.split(" ");
				for (int j=0; j < 20; j++)
					text[i][j] = Integer.parseInt(temp[j]);
			}
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		return text;
	}
}

// Answer is 70600674
// Execution time is 0.003771644 seconds
