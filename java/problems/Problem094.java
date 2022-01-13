package problems;

public class Problem094 extends Solution {

  private static final int N = 1000000000;

  public static void main(String[] args) {
    new Problem094().run();
  }

  @Override
  public String solve() {
    long sum = 0;
    for (long a = 3, limit = (N + 1) / 3; a <= limit; a += 2) {
      double sqrt = Math.sqrt((3 * a + 1) * (a - 1));
      if (sqrt == (int) sqrt && (((long) sqrt) * (a + 1)) % 4 == 0) {
        System.out.println(sqrt);
        System.out.println(a);
        sum += 3 * a + 1;
      }

      sqrt = Math.sqrt((3 * a - 1) * (a + 1));
      if (sqrt == (int) sqrt && (((long) sqrt) * (a - 1)) % 4 == 0) {
        System.out.println(sqrt);
        System.out.println(a);
        sum += 3 * a - 1;
      }
    }
    return String.valueOf(sum);
  }
}
