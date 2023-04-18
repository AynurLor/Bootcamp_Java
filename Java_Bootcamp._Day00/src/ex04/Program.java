import java.util.Scanner;

public class Program04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if (text.length() > 999) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        int[][] mas = new int[999][3];
        char[] symbol;
        int countSymbol = 0;
        symbol = text.toCharArray();

        for (int i = 0; i <text.length() ; i++) {
            if (!containsSymbol(mas, symbol[i], countSymbol)) {
                mas[countSymbol][0] = symbol[i];
                mas[countSymbol][1] += 1;
                countSymbol++;
            } else {
                incrementNumber(mas, symbol[i], countSymbol);
            }
        }
        bubbleSort(mas, countSymbol);
        addStatistic(mas);
        if (mas[0][0] != 0) printStatic(mas);
    }

    public static void bubbleSort(int[][] array, int countSymbol) {
        for (int i = 0; i < countSymbol - 1; i++) {
            for (int j = 0; j < countSymbol - i - 1; j++) {
                if (array[j][1] == array[j + 1][1] && array[j][0] > array[j + 1][0] ||
                    array[j][1] < array[j + 1][1]) {
                    int temp = array[j][0];
                    int temp2 = array[j][1];
                    array[j][0] = array[j + 1][0];
                    array[j][1] = array[j + 1][1];
                    array[j + 1][0] = temp;
                    array[j + 1][1] = temp2;
                }
            }
        }
    }

    public static void addStatistic(int[][] array) {
        int max = array[0][1];
        for (int i = 0; max != 0 && i < array.length; i++) {
            array[i][2] = array[i][1] * 10 / max;
        }
    }
    private static void printStatic(int[][] mas) {
        for (int i = 0; i < 12; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                if (mas[j][0] != 0 && mas[j][1] != 0) {
                    if (i == 11) {
                        System.out.print((char)mas[j][0]);
                    } else if (12 - mas[j][2] - i + 1 == 3) {
                        System.out.print(mas[j][1]);
                    } else if (12 - mas[j][2] - i + 1 < 3) {
                        {
                            System.out.print("#");
                        }
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                }
            }
        }
    }

    public static boolean containsSymbol(int[][] mas, char symbol, int countSymbol) {
        for (int i = 0; i < countSymbol; i++) {
            if (mas[i][0] == (int)symbol) return true;
        }
        return false;
    }
    public static void incrementNumber(int[][] mas, char symbol, int countSymbol) {
        for (int i = 0; i < countSymbol; i++) {
            if (mas[i][0] == (int)symbol) {
                mas[i][1] += 1;
                break;
            }
        }
    }
}
