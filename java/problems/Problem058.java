package problems;

public class Problem058 extends Solution {
  private int total = 1;
  private int numPrimes = 0;

  public static void main(String[] args) {
    new Problem058().run();
  }

  @Override
  public String solve() {
    int side = 3;
    for (int candidate = 1; true; side += 2) {
      for (int i = 0; i < 3; i++) {
        candidate += side - 1;
        if (isPrime(candidate)) this.numPrimes++;
      }
      candidate += side - 1;
      this.total += 4;
      if ((double) this.numPrimes / this.total <= 0.1) break;
    }
    return String.valueOf(side);
  }

  private boolean isPrime(int n) {
    if (n <= 3) {
      return n > 1;
    } else if (n % 2 == 0 || n % 3 == 0) {
      return false;
    } else {
      for (int i = 5, end = (int) Math.sqrt(n); i <= end; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public void printExtraOutput() {
    System.out.printf("Number of primes on the diagonals: %d\n", this.numPrimes);
    System.out.printf("Total count of numbers on the diagonals: %d\n", this.total);
    System.out.printf("Prime ratio: %f%%\n", 100.0 * this.numPrimes / this.total);
  }
}
