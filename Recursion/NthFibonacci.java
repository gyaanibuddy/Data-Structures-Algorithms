import java.util.Scanner;
public class NthFibonacci
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        System.out.println("The " + n + "th Fibonacci number is : " + calcFibonacci(n));
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