package processor;

public class PreProcessorToLower implements PreProcessor{
    public String processorAction(String line) {
        return line.toLowerCase();
    }
}
