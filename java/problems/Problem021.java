package problems;

/**
 * Problem021.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 31, 2014
 */
public class Problem021 extends Solution {

  private static final int N = 10000;

  public static void main(String[] args) {
    new Problem021().run();
  }

  @Override
  public String solve() {
    int sum = 0;
    for (int i = 1; i < N; i++) {
      if (isAmicable(i)) {
        sum += i;
      }
    }
    return String.valueOf(sum);
  }

  public boolean isAmicable(int a) {
    int b = sumFactor(a);
    return (a != b) && (a == sumFactor(b));
  }

  public int sumFactor(int n) {
    if (n == 0) {
      return 0;
    }
    int sum = 1;
    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrt; i++) {
      if (n % i == 0) {
        sum += i + n / i;
      }
    }
    if (n == sqrt * sqrt) {
      sum -= sqrt;
    }
    return sum;
  }
}