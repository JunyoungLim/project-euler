/**
 *
 */
package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import java.math.BigInteger;

/**
 * Problem013.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 17, 2014
 */
public class Problem013 {

  private static final String[] nums = read();

  public static void run() {
    BigInteger ans = BigInteger.ZERO;
    for (String s : nums) {
      ans = ans.add(new BigInteger(s));
    }
    System.out.println(ans.toString().substring(0, 10));
  }


  // read in list of numbers
  public static String[] read() {
    String[] text = new String[100];
    File file = new File("text013.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      for (int i = 0; (line = br.readLine()) != null; i++) {
        text[i] = line;
      }
    } catch (IOException e) {
      System.err.println(e);
    }
    return text;
  }
}

// Answer is 5537376230
// Execution time is 6.157391 ms

