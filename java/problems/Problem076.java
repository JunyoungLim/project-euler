package problems;

public class Problem076 extends Solution {
  private static final int N = 100;

  public static void main(String[] args) {
    new Problem076().run();
  }

  @Override
  public String solve() {
    int[] sumWays = new int[N + 1];
    sumWays[0] = 1;
    for (int i = 1; i < sumWays.length; i++) {
      for (int j = i; j < sumWays.length; j++) {
        sumWays[j] += sumWays[j - i];
      }
    }
    return String.valueOf(sumWays[N] - 1);
  }
}
