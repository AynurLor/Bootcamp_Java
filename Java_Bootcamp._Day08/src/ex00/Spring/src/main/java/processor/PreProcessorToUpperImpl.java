package processor;

public class PreProcessorToUpperImpl implements PreProcessor{
    public String processorAction(String line) {
        return line.toUpperCase();
    }
}
