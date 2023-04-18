package display;

import render.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
    private Renderer render;
//    String answer;
    public PrinterWithDateTimeImpl(Renderer renderer) {
        render = renderer;
    }
//    public void setData(LocalDateTime data){
//        answer = answer.concat(" " + data.toString());
//    }
    public void print(LocalDateTime data) {
        render.print(data.toString());
//        System.out.println(data);
    }
}
