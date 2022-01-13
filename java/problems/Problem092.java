package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem092 extends Solution {
  private static final int N = 10000000;

  public static void main(String[] args) {
    new Problem092().run();
  }

  @Override
  public String solve() {
    int[] sum = sumDigitsSquares(N);
    int[] state = new int[N];
    List<Integer> visited = new ArrayList<>();
    state[89] = 89;
    state[1] = 1;
    for (int i = 1; i < N; i++) {
      for (int curNum = i; true; curNum = sum[curNum]) {
        if (state[curNum] == 89) {
          for (int n : visited) state[n] = 89;
          break;
        } else if (state[curNum] == 1) {
          for (int n : visited) state[n] = 1;
          break;
        } else {
          visited.add(curNum);
        }
      }
      visited.clear();
    }
    int count = 0;
    for (int s : state) if (s == 89) count++;
    return String.valueOf(count);
  }

  private int[] sumDigitsSquares(int N) {
    int[] sum = new int[N];
    for (int i = 1; i < N; i++) {
      int d = i % 10;
      sum[i] = d * d + sum[i / 10];
    }
    return sum;
  }
}
