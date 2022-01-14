package problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import utils.FileIO;

public class Problem079 extends Solution {
  private static final int LOGIN_LEN = 3;

  private final Map<Integer, Set<Integer>> keyToParentSet = new HashMap<>();

  public static void main(String[] args) {
    new Problem079().run();
  }

  @Override
  public String solve() {
    List<String> logins = FileIO.readLines("p079.txt");
    int[] loginKeys = new int[LOGIN_LEN];

    for (String login : logins) {
      // Fill in the three integers.
      for (int i = 0; i < LOGIN_LEN; i++) {
        loginKeys[i] = login.charAt(i) - '0';
      }
      // For each integer key, record all the parents (preceding digits).
      for (int i = 0; i < LOGIN_LEN; i++) {
        keyToParentSet.putIfAbsent(loginKeys[i], new HashSet<>());
        for (int j = i - 1; j >= 0; j--) {
          keyToParentSet.get(loginKeys[i]).add(loginKeys[j]);
        }
      }
    }
    // Sort the integer keys by ascending order of number of parents.
    PriorityQueue<Integer> queue = new PriorityQueue<>(keyToParentSet.size(),
        Comparator.comparingInt(t -> keyToParentSet.get(t).size()));
    queue.addAll(keyToParentSet.keySet());

    // Build the passcode from the queue.
    StringBuilder passcode = new StringBuilder();
    while (!queue.isEmpty()) passcode.append(queue.poll());
    return passcode.toString();
  }

  @Override
  public void printExtraOutput() {
    for (int key : this.keyToParentSet.keySet()) {
      System.out.println(key + ": " + this.keyToParentSet.get(key));
    }
  }
}
