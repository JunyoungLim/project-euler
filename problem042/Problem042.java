/**
 * 
 */
package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem042.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Feb 27, 2015
 */
public class Problem042
{
	private static final String[] name = read(); // Reading takes ~ 10 ms
	
	// Algorithm execution time is ~ 4.67 ms
	public static void run()
	{
		int count = 0;
		for (String s : name)
		{
			int val = 0;
			char[] arr = s.toCharArray();
			for (char c : arr) val += c - 'A' + 1;
			
			val *= 2;
			int n = (int)Math.sqrt(val);
			if (val == n * (n + 1)) count++;
		}
		System.out.println(count);
	}
	
	// read in file of 1786 words
	public static String[] read()
	{
		String[] text = new String[1786];
		File file = new File("text042.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line = br.readLine();
			line = line.replace("\"", "");
			text = line.split(",");
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		return text;
	}
}


// Answer is 162
// Algorithm execution time is 4.671288 ms
// Total Execution time is 14.992408 ms

