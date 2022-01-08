package problems.p001;

/**
 * Problem001.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem001 {
	public static void main(String[] args) {
		int ans = sumMultiple(3,999) + sumMultiple(5,999) - sumMultiple(15,999);
		System.out.println(ans);
	}

	private static int sumMultiple(int divisor, int num) {
		int last = num / divisor;
  	int sum = (last * (last + 1)) / 2;
  	return sum * divisor;
	}
}