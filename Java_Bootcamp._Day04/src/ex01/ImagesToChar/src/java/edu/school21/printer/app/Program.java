package edu.school21.printer.app;

import edu.school21.printer.logic.ReadImage;

import java.io.IOException;
public class Program {
    public static void main(String[] args) throws IOException {

        String firstSymbol = args[0];
        String secondSymbol = args[1];
        ReadImage img = new ReadImage(firstSymbol, secondSymbol, "/resources/it.bmp");
        img.parseImage();
    }
}



