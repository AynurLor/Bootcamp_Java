
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SiteReader {
    private static final String filesUrl= "files_urls.txt";
    private List<String> pathContains = new ArrayList<String>();

    public List<String> getContains() {
        return pathContains;
    }




    void parseFile() {
        File fl = new File(filesUrl);

        try (BufferedReader reader = new BufferedReader(new FileReader(filesUrl))) {
            String line;
            while ((line = reader.readLine()) != null) {
                pathContains.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
