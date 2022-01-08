/**
 * 
 */
package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem018.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 24, 2014
 */
public class Problem018
{
	private static int[][] triangle = read();
	
	public static void run()
	{
		for (int i=triangle.length-1; i >= 1; i--)
		{
			for (int j=0; j < i; j++)
			{
				triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
			}
		}
		System.out.println(triangle[0][0]);
	}
	
	
	
	public static int[][] read()
	{
		int[][] text = new int[15][];
		File file = new File("text018.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			for (int i=0; (line = br.readLine()) != null; i++)
			{
				String[] temp = line.split(" ");
				text[i] = new int[i+1];
				for (int j=0; j <= i; j++)
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



// Answer is 1074
// Execution time is 3.042578 ms
//
// Exactly same solution as Problem067

