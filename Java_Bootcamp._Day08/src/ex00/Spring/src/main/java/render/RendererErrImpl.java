package render;

import processor.PreProcessor;

public class RendererErrImpl implements Renderer{
    PreProcessor processor;

    public RendererErrImpl(PreProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void print(String line) {
        System.err.println(processor.processorAction(line));
    }
}
