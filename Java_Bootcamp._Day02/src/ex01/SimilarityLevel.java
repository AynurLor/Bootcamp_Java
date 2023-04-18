import java.io.*;
import java.util.ArrayList;

public class SimilarityLevel {
    private static final String dictionaryPath = "Dictionary.txt";
    private ArrayList<String> dictionaryList = new ArrayList<>(999);
    private ArrayList<String> dictionaryList1 = new ArrayList<>(999);
    private ArrayList<String> dictionaryList2 = new ArrayList<>(999);
    private static Integer sizeDictionary = 0;
    private String pathFile1;
    private String pathFile2;
    private ArrayList<Integer> dictionaryFile1 = new ArrayList<>(999);
    private ArrayList<Integer> dictionaryFile2 = new ArrayList<>(999);

    public SimilarityLevel(String pathFile1, String pathFile2) {
        if (pathFile1 == null || pathFile2 == null ) {
            System.err.println("Path is null");
            System.exit(-1);
        }
        this.pathFile1 = pathFile1;
        this.pathFile2 = pathFile2;
    }

    public void setPathFile1(String pathFile1) {
        this.pathFile1 = pathFile1;
    }

    public void setPathFile2(String pathFile2) {
        this.pathFile2 = pathFile2;
    }

    public void creatingDictionary() {
        try {
            InputStream inputStream1 = new FileInputStream(pathFile1);
            InputStream inputStream2 = new FileInputStream(pathFile2);
            OutputStream outputStream = new FileOutputStream(dictionaryPath);

            BufferedInputStream bufferFile1 = new BufferedInputStream(new FileInputStream(pathFile1), 200);
            BufferedInputStream bufferFile2 = new BufferedInputStream(new FileInputStream(pathFile2), 200);
            int bytes = -1;
            String word = "";
            while ((bytes = bufferFile1.read()) != -1) {
                if (bytes == ' ' || bytes == '\n') {
                        dictionaryList1.add(word);
                    if (!dictionaryList.contains(word)) {
                        dictionaryList.add(word);
                        outputStream.write(new String(word + "," + (char)bytes).getBytes());
                    }
                    word = "";
                } else {
                    word = new String(word + (char)bytes);
                }
            }
            dictionaryList1.add(word);
            if (!dictionaryList.contains(word)) {
                dictionaryList.add(word);
                outputStream.write(word.getBytes());
            }
            word = "";
            outputStream.write(", ".getBytes());

            while ((bytes = bufferFile2.read()) != -1) {
                if (bytes == ' ' || bytes == '\n') {
                    dictionaryList2.add(word);
                    if (!dictionaryList.contains(word)) {
                        dictionaryList.add(word);
                        outputStream.write(new String(word + "," + (char)bytes).getBytes());
                    }
                    word = "";
                } else {
                    word = new String(word + (char)bytes);
                }
            }
            dictionaryList2.add(word);
            if (!dictionaryList.contains(word)) {
                dictionaryList.add(word);
                outputStream.write(word.getBytes());
            }
            inputStream1.close();inputStream2.close();outputStream.close();bufferFile1.close();bufferFile2.close();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }


    public void getVectorFromTexts() {
        int count = 0;
        for (String list : dictionaryList) {
//            цикл для перебора 1 текста
            for (String node : dictionaryList1) {
                if (list.equals(node)) {
                    count++;
                }
            }
            dictionaryFile1.add(count);
            count = 0;
//            цикл для перебора 2 текста
            for (String node : dictionaryList2) {
                if (list.equals(node)) {
                    count++;
                }
            }
            dictionaryFile2.add(count);
            count = 0;
        }
    }
    public void calculateSimilarity() {
        Integer numerator = 0, multNum1 = 0,  multNum2 = 0;

        for (int i = 0; i < dictionaryList.size(); i++) {
            numerator += dictionaryFile1.get(i) * dictionaryFile2.get(i);
            multNum1 += dictionaryFile1.get(i) * dictionaryFile1.get(i);
            multNum2 += dictionaryFile2.get(i) * dictionaryFile2.get(i);
        }
        Double denominator = Math.sqrt(multNum1) * Math.sqrt(multNum2);
        if (denominator == 0)  {
            System.err.println("division by 0 is prohibited");
            System.exit(-1);
        }
        Double similarity = (numerator / denominator);
        System.out.printf("Similarity = %.02f", Math.floor(similarity * 100) / 100.0);
    }

}
