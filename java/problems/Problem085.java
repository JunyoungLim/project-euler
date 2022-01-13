package problems;

public class Problem085 extends Solution {
  private static final int N = 2000000;

  public static void main(String[] args) {
    new Problem085().run();
  }

  /**
   * Let n, m where n <= m the side lengths of the grid,
   * and N, the target number of rectangles contained in the grid,
   * we have:                 n C 2 * m C 2 ~ N
   * Simplify it, we have:    n(n-1)m(m-1) ~ 4N
   */
  @Override
  public String solve() {
    int smallestDiff = N, area = 0;
    // Compute the upper bound of n by solving (n-1)^4 = 4N.
    int nLimit = (int) Math.sqrt(Math.sqrt(4 * N)) + 1;
    for (int n = 2; n <= nLimit; n++) {
      // Compute m by solving n(n-1)m(m-1) = 4N.
      int m = (int) Math.sqrt((4.0 * N) / (n * (n - 1))) + 1;
      // Compute the difference between the target N and the actual N.
      int diff = Math.abs(N - n * (n - 1) * m * (m - 1) / 4);
      if (diff < smallestDiff) {
        smallestDiff = diff;
        area = (n - 1) * (m - 1);
      }
    }
    return String.valueOf(area);
  }
}
