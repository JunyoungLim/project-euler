package problems;

public class Problem719 {

  public static void main(String[] args) {
    long N = 1000000;
    long sum = 0;
    for (long num = 4; num <= N; num++) {
      if (isSumOfDecimalSplits(num, num * num)) {
        sum += num * num;
      }
    }
    System.out.println(sum);
  }

  private static boolean isSumOfDecimalSplits(long target, long number) {
    if (target < 0 || target > number) {
      return false;
    }
    if (target == number) {
      return true;
    }
    int numDigits = (int) Math.log10(target) + 1;
    if ((int) Math.log10(target) == (int) Math.log10(number)) {
      numDigits--;
    }
    if (numDigits == 0) {
      return false;
    }
    long divisor = (long) Math.pow(10, numDigits);
    while (divisor > 1) {
      if (isSumOfDecimalSplits(target - number % divisor, number / divisor)) {
        return true;
      }
      divisor /= 10;
    }
    return false;
  }
}
