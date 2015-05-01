public class Problem001
{
    public static void run2()
    {
        System.out.println(sumMultiple(3,999) + sumMultiple(5,999) - sumMultiple(15,999));
    }
    
    public static int sumMultiple(int divisor, int num)
    {
        int sum = 0;
        for (int i=0; i <= num; i++)
        {
            if (i%divisor == 0) sum += i;
        }
        return sum;
    }
    
    public static void run()
    {
        int sum = 0;
        for (int i=3; i < 1000; i++)
        {
            if (i%3 == 0 || i%5 == 0) sum += i;
        }
        System.out.println(sum);
    }
}
