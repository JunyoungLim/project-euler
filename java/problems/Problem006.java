/**
 *
 */
package problems;

/**
 * Problem006.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 15, 2014
 */
public class Problem006 {

  private static final int NUM = 100;

  public static void run() {
    int sumsquare = (NUM * (NUM + 1) * (2 * NUM + 1)) / 6; //sum of the squares
    int squaresum = (int) Math.pow((NUM) * (NUM + 1) / 2, 2);  //square of the sum
    System.out.println(Math.abs(squaresum - sumsquare));

  }

}

// Answer is 25164150
// Execution time is .789075 ms
