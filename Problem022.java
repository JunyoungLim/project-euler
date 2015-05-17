/**
 * 
 */
package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Problem022.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Jan 1, 2015
 */
public class Problem022 implements textFile.Texts
{
	private static String[] NAME = read();
	
	public static void run()
	{
		Arrays.sort(NAME);
		
		int score = 0, sum = 0;
		
		for (int i=0; i < NAME.length; i++)
		{
			sum = 0;
			char[] arr = NAME[i].toCharArray();
			for (char c : arr) sum += c - 'A' + 1;
			score += sum * (i+1);
		}
		System.out.println(score);
	}
	
	public static String[] read()
	{
		String[] text = new String[5000];
		File file = new File(text022);
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line = br.readLine();
			line = line.replace("\"", "");
			line = line.replace(",", " ");
			text = line.split(" ");
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		return text;
	}
}



// Answer is 871198282
// Execution time is 0.035005436 seconds

