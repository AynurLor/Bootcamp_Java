import java.util.Scanner;

import static java.lang.Math.sqrt;

class Program02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int countCoffee = 0;
        while (number != 42) {

            countCoffee += isNaturalNumber(sumNumber(number))? 1 : 0;
            if (number != 42) {
                number = sc.nextInt();
            }
        }
        System.out.println("Count of coffee-request – " + countCoffee);
        sc.close();
    }

    public static boolean isNaturalNumber(int number) {
        if (number < 2)
            return false;
        double s = sqrt(number);
        for (int i = 2; i <= s; i++) {
            if (number % i == 0) {
                return false;
                }
        }
        return true;
    }

    public static int sumNumber(int number) {
        int sum = 0;
        while (number >= 1) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}