package problems;

/**
 * Problem005.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem005 extends Solution {

  public static void main(String[] args) {
    new Problem005().run();
  }

  @Override
  public String solve() {
    long ans = 1;
    for (int i = 2; i <= 20; i++) {
      ans = lcm(ans, i);
    }
    return String.valueOf(ans);
  }

  private long gcd(long a, long b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
  }

  private long lcm(long a, long b) {
    return a * b / gcd(a, b);
  }
}