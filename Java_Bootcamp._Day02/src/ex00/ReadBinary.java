
import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class ReadBinary {
    private static final String Signature = "signatures.txt";
    private String Result_File = "result.txt";
    private Map<String, String> Signatures;

    public ReadBinary() {
        Signatures = new HashMap<String, String>();
        readSignatures();
    }

    public void detectFileType(String filePath) {
        String fileSignature = getFileSignature(filePath);
        String fileType = Signatures.get(fileSignature);
        if (fileType != null) {
            writeResultToFile(fileType);
            System.out.println("PROCESSED");
        } else {
            System.out.println("UNDEFINED");
        }
//        String result = fileType != null ? fileType : "UNDEFINED";
    }

    private String getFileSignature(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            int byteRead = 0, i = 0;
            while ((byteRead = inputStream.read()) != -1) {
                if (i++ > 7) break;
                sb.append(String.format("%02X ", byteRead ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString().trim();
    }

    private void readSignatures() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Signature))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                Signatures.put(parts[1], parts[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeResultToFile(String result) {
        try (FileWriter writer = new FileWriter(Result_File, true)) {
            writer.write(result + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
