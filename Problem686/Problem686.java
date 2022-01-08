package Problem686;

public class Problem686 {

  private static final int N = 678910;
  private static final double lowerBound = Math.log10(1.23);
  private static final double upperBound = Math.log10(1.24);

  public static void main(String[] args) {
    int j = 0;
    for (int count = 0; count < N; j++) {
      if (isBound(j)) count++;
    }
    j--;
    System.out.println(j);
  }

  private static boolean isBound(int j) {
    double term = j * Math.log10(2);
    double diff = term - Math.floor(term);
    return lowerBound < diff && diff < upperBound;
  }
}
