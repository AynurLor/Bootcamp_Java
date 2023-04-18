import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        ReadBinary read = new ReadBinary();

        Scanner sc = new Scanner(System.in);
        checkError(sc);
        String line = "";
         while (!(line = sc.nextLine()).equals("42")) {
             checkError(sc);
             read.detectFileType(line);
         }
         sc.close();

    }

    public static void checkError(Scanner sc) {
        if (!sc.hasNext()) {
            sc.close();
            System.err.println("Error");
            System.exit(-1);
        }
    }
}
