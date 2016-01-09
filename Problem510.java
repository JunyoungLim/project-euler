import java.util.*;
public class Problem510
{

	/**
	 * 
	 */
	private static final int LIMIT = (int) Math.pow(10, 9);
	
	public static void main(String[] args)
	{
		long start = System.nanoTime();
		HashSet<Double> set = new HashSet<Double>();
		
		int sqrtlim = (int) Math.sqrt(LIMIT);
		int[] sqr = new int[sqrtlim + 1];
		for (int i = 0; i <= sqrtlim; i++)
			sqr[i] = i*i;
		
		long a = 4, b = 4, c = 1; // fundamental combination
		long lastindex = LIMIT/4;
		long sum = (4 + 4 + 1) * (lastindex) * (lastindex + 1) / 2;		
		
		// advanced combination in form of n^2 / m^2
		for (int i = 1; i + i + 1 < sqr.length; i++)
		{
			long denom = sqr[i];
			long startindex = i * (i + 1);
			c = startindex * startindex;
			long numer = sqr[i + i + 1];
			double ratio = (double) numer / denom;
			b = (long) (numer * c / denom);
			
			if (b > LIMIT) break;
			if (set.contains(ratio)) continue;
			
			long clim = (long) (LIMIT / ratio);
			lastindex = clim / c;
			
			a = b * c / (b + c - 2 * (long) Math.sqrt(b * c));
			
			sum += (a + b + c) * lastindex * (lastindex + 1) / 2;
			set.add(ratio);
			
			for (int j = i + i + 2; j < sqr.length; j++)
			{
				startindex += i;
				c = startindex * startindex;
				numer = sqr[j];
				ratio = (double) numer / denom;
				b = (long) (numer * c / denom);
				
				if (b > LIMIT) break;
				if (set.contains(ratio)) continue;
				
				clim = (long) (LIMIT / ratio);
				lastindex = clim / c;
				
				a = b * c / (b + c - 2 * (long) Math.sqrt(b * c));
				
				sum += (a + b + c) * lastindex * (lastindex + 1) / 2;
				set.add(ratio);
			}
		}
		System.out.println(sum);
		long end = System.nanoTime();
		System.out.println("Execution time is " + (end - start)/1000000d + " ms");

	}

}
