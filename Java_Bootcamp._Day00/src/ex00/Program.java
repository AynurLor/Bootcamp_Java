import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int number = scaner.nextInt();
        int sum = 0;
        sum += number % 10;
        number /= 10;
        sum += number % 10;
        number /= 10;
        sum += number % 10;
        number /= 10;
        sum += number % 10;
        number /= 10;
        sum += number % 10;
        number /= 10;
        sum += number % 10;
        System.out.println(sum);
    }
}
