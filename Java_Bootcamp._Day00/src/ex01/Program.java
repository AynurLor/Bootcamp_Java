import java.util.Scanner;

import static java.lang.Math.sqrt;

class Program01 {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int number = scaner.nextInt();
        int count = 0;
        if (number == 0 || number < -1 || number == 1) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        } else {
                double s = sqrt(number);
                for (int i = 2; i <= s; i++) {
                    if (number % i == 0) {
                        System.out.println("false " + (count + 1));
                        return;
                    }
                    count++;
                }

                System.out.println("true " + (count + 1));
            }
        scaner.close();
    }
}