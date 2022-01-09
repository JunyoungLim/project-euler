package problems;

/**
 * Problem006.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 15, 2014
 */
public class Problem006 implements Solution {

  private static final int NUM = 100;

  public static void main(String[] args) {
    System.out.println(new Problem006().solve());
  }

  @Override
  public String solve() {
    int sumSquare = (NUM * (NUM + 1) * (2 * NUM + 1)) / 6; //sum of the squares
    int squareSum = (int) Math.pow((NUM) * (NUM + 1) / 2, 2);  //square of the sum
    return String.valueOf(Math.abs(squareSum - sumSquare));
  }
}