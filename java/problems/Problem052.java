/**
 *
 */
package problems;

/**
 * Problem052.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Mar 23, 2015
 */
public class Problem052 {

  public static void run() {
    boolean notFound = true;

    for (int i = 100000; notFound; i *= 10) // need at least six digits
    {
      for (int j = (i * 10) / 6; j >= i; j--) {
        if (isEqual(j, j * 2) && isEqual(j, j * 3) && isEqual(j, j * 4) && isEqual(j, j * 5)
            && isEqual(j, j * 6)) {
          System.out.println(j);
          return;
        }
      }
    }

  }

  public static boolean isEqual(int a, int b) {
    int[] arr = new int[10];

    int temp1 = a;
    int temp2 = b;
    while (temp1 > 0) {
      arr[temp1 % 10]++;
      arr[temp2 % 10]--;
      temp1 /= 10;
      temp2 /= 10;
    }

    for (int i = 0; i < 10; i++) {
      if (arr[i] != 0) {
        return false;
      }
    }

    return true;
  }
}

// Answer is 142857
// Execution time is 4.994517 ms
	


