public class Program {
    public static void main(String[] args) {
        SimilarityLevel equally = new SimilarityLevel(args[0], args[1]);
        equally.creatingDictionary();
        equally.getVectorFromTexts();
        equally.calculateSimilarity();
    }
}
