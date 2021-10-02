import java.util.Scanner;
public class NthFibonacci
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter limit :");
        int n = sc.nextInt();
        int result = calcFibonacci(n);
        System.out.println("Nth Fibonacci number = " + result);
    }

    public static int calcFibonacci(int n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }

        return calcFibonacci(n-1) + calcFibonacci(n-2);
    }
}
