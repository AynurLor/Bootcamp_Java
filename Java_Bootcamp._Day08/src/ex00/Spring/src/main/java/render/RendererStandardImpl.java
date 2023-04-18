package render;

import processor.PreProcessor;

public class RendererStandardImpl implements Renderer{
    PreProcessor process;
    public RendererStandardImpl(PreProcessor processor) {
        this.process = processor;
    }

    @Override
    public void print(String line) {
        System.out.println(process.processorAction(line));
    }
}
