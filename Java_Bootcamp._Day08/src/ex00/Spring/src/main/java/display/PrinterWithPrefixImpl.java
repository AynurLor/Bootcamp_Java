package display;

import render.Renderer;

public class PrinterWithPrefixImpl implements Printer{
    private String prefix;
    Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        prefix = "";
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public void print(String text) {
        renderer.print(this.prefix + " " + text);
    }
}
