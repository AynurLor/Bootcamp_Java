import java.util.Scanner;

public class Progres03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String week = "";
        int countWeek = 1;
        int degree = 1;
        long statistic = 0;
        while (!(week = sc.nextLine()).equals("42") && countWeek <= 18) {
            if (!week.equals("Week " + countWeek) || !sc.hasNext()) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int min = sc.nextInt();
            if (!(min >= 1 & min <= 9)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
//            check is number
            for (int i = 0; i < 4; i++) {
                int value = sc.nextInt();
                if (!(min >= 1 & min <= 9)) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                if (value < min) min = value;
            }
            statistic += min * degree;
            degree *= 10;
            sc.nextLine();
            countWeek++;
        }
        long count = 0;
        for (int i = 1; i <= countWeek - 1; i++)
        {
            System.out.printf("Week " + i + "\t");
            count = statistic % 10;
            statistic /= 10;
            for (int j = 0; j < count; j++)
                System.out.print("=");
            System.out.println(">");
        }
        sc.close();
    }
}
