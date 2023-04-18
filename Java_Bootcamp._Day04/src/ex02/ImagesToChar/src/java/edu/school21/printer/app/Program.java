package edu.school21.printer.app;

//import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander;
import edu.school21.printer.logic.IdentityArgs;
import edu.school21.printer.logic.ReadImage;

import java.io.IOException;
public class Program {
    public static void main(String[] args) throws IOException {
        IdentityArgs arg = new IdentityArgs();
        JCommander jCommander = new JCommander(arg);
        jCommander.parse(args);

        ReadImage img = new ReadImage(arg.getWhileColor(), arg.getBlackColor(), "/resources/it.bmp");
        img.parseImage();
    }
}

