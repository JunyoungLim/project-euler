/**
 * 
 */
package problems;

/**
 * Problem001.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem001 {
	public static void main(String[] args) {
		System.out.println(solve());
	}

	public static int solve() {
		return sumMultiple(3,999) + sumMultiple(5,999) - sumMultiple(15,999);
	}

	public static int sumMultiple(int divisor, int num) {
		int last = num / divisor;
  	int sum = (last * (last + 1)) / 2;
  	return sum*divisor;
	}
}