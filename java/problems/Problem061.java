package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Problem061 extends Solution {
  private final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
  private final int[] record = new int[9];

  public static void main(String[] args) {
    new Problem061().run();
  }

  @Override
  public String solve() {
    double a = 0.5, b = 0.5;
    for (int s = 3; s <= 8; s++, a += 0.5, b -= 0.5) {
      this.map.put(s, new HashMap<>());
      int startN = (int) Math.ceil((Math.sqrt(4 * a * 1000 + b * b) - b) / (2 * a));
      int endN  = (int) Math.floor((Math.sqrt(4 * a * 9999 + b * b) - b) / (2 * a));
      for (int n = startN; n <= endN; n++) {
        int polyNum = (int) (a * n * n + b * n);
        int head = polyNum / 100, tail = polyNum % 100;
        this.map.get(s).put(head, tail);
      }
    }
    // Start the recursive search from the triangle set (n = 3).
    for (Entry<Integer, Integer> polyNum : this.map.get(3).entrySet()) {
      int head = polyNum.getKey(), tail = polyNum.getValue();
      this.record[3] = head * 100 + tail;
      if (search(1, tail)) {
        return String.valueOf(Arrays.stream(this.record).sum());
      }
    }
    return null;
  }

  private boolean search(int count, int prevTail) {
    // Termination case: check if the last tail equals to the initial head.
    if (count == 6) return (prevTail == this.record[3] / 100);
    // Recursive case: search for the next polygonal set.
    for (int s = 3; s <= 8; s++) {
      // If already visited, skip.
      if (this.record[s] != 0) continue;
      // For each number in the current polygonal set,
      for (Entry<Integer, Integer> polyNum : this.map.get(s).entrySet()) {
        int head = polyNum.getKey(), tail = polyNum.getValue();
        // If the head of the number is not the tail from the previous number, skip.
        if (head != prevTail) continue;
        // If the head and the tail match, visit current number.
        this.record[s] = head * 100 + tail;
        // Continue search for the next set.
        if (search(count + 1, tail)) return true;
        // By this time, we didn't find a cycle, so reset the visit mark.
        this.record[s] = 0;
      }
    }
    return false;
  }

  @Override
  public void printExtraOutput() {
    boolean[] printed = new boolean[9];
    for (int s = 3, count = 0; count < 6; count++) {
      printed[s] = true;
      System.out.printf("{%d: %d} -> ", s, this.record[s]);
      for (int t = 3; t <= 8; t++) {
        if (printed[t]) continue;
        if (this.record[s] % 100 == this.record[t] / 100) {
          s = t;
          break;
        }
      }
    }
    System.out.printf("{%d: %d}", 3, this.record[3]);
  }
}
