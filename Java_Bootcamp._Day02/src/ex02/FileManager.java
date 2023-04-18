import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    private static Path currentFolder;

    public Path getCurrentFolder() {
        return currentFolder;
    }
    public FileManager(String folderPath) {
        currentFolder = Paths.get(folderPath).toAbsolutePath().normalize();
    }

    public void executeCommand(String command) throws IOException {
//        String[] tokens = command.trim().split("\\s+");
        Scanner sc = new Scanner(System.in);
        if (command.trim().equals("cd")) {
            String path = sc.nextLine();
            changeFolder(path);
        } else if (command.trim().equals("ls")) {
            listOfFiles();
        } else if (command.trim().equals("mv")) {
            String[] pathFrom = sc.nextLine().split(" ");
            moveOrRename(pathFrom[0], pathFrom[1]);
        }
//        sc.close();
    }

    private void moveOrRename(String from, String to) throws IOException {
        Path source = currentFolder.resolve(from);
        Path destination = currentFolder.resolve(to);

        if (Files.isDirectory(destination)) {
            destination = destination.resolve(source.getFileName());
        }

        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void listOfFiles() throws IOException {
        List<Path> files = new ArrayList<>();
        List<Path> folders = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentFolder)) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    folders.add(path);
                } else {
                    files.add(path);
                }
            }
        }

        printPaths(folders, "FOLDER");
        printPaths(files, "FILE");
    }

    private void changeFolder(String folderName) throws IOException {
        Path folder = currentFolder.resolve(folderName);

        if (!Files.isDirectory(folder)) {
            System.out.println("Not a directory: " + folderName);
            return;
        }

        currentFolder = folder.normalize();
    }

    private static void printPaths(List<Path> paths, String type) {
        for (Path path : paths) {
            String size = "";
            try {
                long fileSize = Files.size(path);
                size = String.format("%d KB", fileSize / 1024);
            } catch (IOException ex) {}

            System.out.printf("%s %-8s %s\n", type, size, path.getFileName());
        }
    }
}
