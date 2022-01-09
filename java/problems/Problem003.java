/**
 * 
 */
package problems;

/**
 * Problem003.java
 * @author JunyoungLim
 *
 * @version 1.00
 * @since Dec 14, 2014
 */
public class Problem003 {
	public static void main(String[] args) {
		long d = 600851475143L;
		
		for (int i = 3; i < Math.sqrt(d); i+=2)
		{
			if (d%i == 0)
				while (d%i == 0) d /= i;
		}
		System.out.println(d);
	}

	// universal solution for finding the largest prime factor : not necessary for this specific problem
	public static int getLargestPrimeFactor(int n) {
		if (n == 1) return 1;
		if (n%2 == 0) while (n%2 == 0) n /= 2;
		if (n == 1) return 2;
		
		int i = 3;
		for ( ; i <= (int)Math.sqrt(n); i+=2)
		{
			if (n%i == 0)
				while (n%i == 0) n /= i;
		}
		i -= 2;
		if (n == 1) return i;
		return n;
    	}
}
