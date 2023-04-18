package edu.school21.printer.app;

import edu.school21.printer.logic.ReadImage;

import java.io.IOException;
public class Program {
    public static void main(String[] args) throws IOException {

        String firstSymbol = args[0];
        String secondSymbol = args[1];
        String path = args[2];
        ReadImage img = new ReadImage(firstSymbol, secondSymbol, path);
        img.parseImage();
    }
}
