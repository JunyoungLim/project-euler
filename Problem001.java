
public class Problem001
{
    public static void run()
    {
        System.out.println(sumMultiple(3,999) + sumMultiple(5,999) - sumMultiple(15,999));
    }
    
    public static int sumMultiple(int divisor, int num)
    {
        int last = num/divisor;
        int sum = (last*(last + 1))/2;
        return sum*divisor;
    }
}
