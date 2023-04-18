import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println(args[0]);
        String currentFolder = "";
//        for (String arg : args) {
//            if (arg.startsWith("--current-folder=")) {
                currentFolder = args[0];
//            }
//        }
        if (currentFolder.isEmpty()) {
            System.err.println("Usage: java Program --current-folder=<path>");
            System.exit(-1);
        }
        FileManager fileManager = new FileManager(currentFolder);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(fileManager.getCurrentFolder() + "> ");
                String command = scanner.nextLine();
                if (command.equals("exit")) {
                    break;
                }
                fileManager.executeCommand(command);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }


//        end method
    }


//    end class
}
