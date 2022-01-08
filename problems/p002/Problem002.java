package problems.p002;

/**
 * Problem002.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem002 {
	private static final int LIMIT = 4000000;
	
	public static void main(String[] args) {
		int f = 1;
		int s = 1;
		int fibo = 0;
		int sum = 0;
		while (fibo <= LIMIT)
		{
			fibo = f + s;
			if (fibo%2 == 0) sum += fibo;
			f = s;
			s = fibo;
		}
		System.out.println(sum);
	}
}