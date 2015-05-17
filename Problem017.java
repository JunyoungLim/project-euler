/**
 * 
 */
package problems;

/**
 * Problem017.java
 * @author Ainodyne
 *
 * @version 1.00
 * @since Dec 23, 2014
 */
public class Problem017
{
	private static final String[] UNIT = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static final String[] TENTH = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static final String[] TEN = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static final String THOUSAND = "thousand";
	private static final String HUNDRED = "hundred";
	private static final String AND = "and";
	
	public static void run()
	{
		// 1000
		int fourDigit = UNIT[0].length() + THOUSAND.length(); // one thousand
		
		// 1 to 9
		int unitSum = 0;
		for (String n : UNIT) unitSum += n.length();
		
		// 1 to 99
		int twoDigit = unitSum*9;
		for (String n : TEN) twoDigit += n.length();
		for (String n : TENTH) twoDigit += n.length()*10;
		
		// 1 to 999
		int threeDigit = 0;
		int threeTemp = twoDigit;
		threeTemp += (HUNDRED.length() + AND.length())*99;
		threeTemp += HUNDRED.length();
		for (String u : UNIT)
			threeDigit += u.length()*100 + threeTemp;
		threeDigit += twoDigit; // 1 to 99 (without any hundredth digit)
		
		System.out.println(fourDigit + threeDigit);
	}
}


// Answer is 21124
// Execution time is 0.002075885 seconds


