package problems;

/**
 * Problem002.java
 *
 * @author JunyoungLim
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem002 implements Solution {

  private static final int LIMIT = 4000000;

  public static void main(String[] args) {
    System.out.println(new Problem002().solve());
  }

  @Override
  public String solve() {
    int f = 1;
    int s = 1;
    int fibo = 0;
    int sum = 0;
    while (fibo <= LIMIT) {
      fibo = f + s;
			if (fibo % 2 == 0) {
				sum += fibo;
			}
      f = s;
      s = fibo;
    }
    return String.valueOf(sum);
  }
}