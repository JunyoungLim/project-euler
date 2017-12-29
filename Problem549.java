public class Problem549 {
    public static void main(String[] args) {
        System.out.println(run(100));
    }

    public static int run(int n) {
        boolean[] marked = new boolean[n + 1];
        long factorial = 1;
        int count = 1;

        int sum = 0;
        for (int m = 2; count < n; m++) {
            factorial *= m;
            for (int i = 2; i < n; i++) {
                if (factorial % i == 0) {
                    if (!marked[i]) {
                        sum += m;
                        count++;
                        marked[i] = true;
                    }
                }
            }
        }

        return sum;
    }
}
