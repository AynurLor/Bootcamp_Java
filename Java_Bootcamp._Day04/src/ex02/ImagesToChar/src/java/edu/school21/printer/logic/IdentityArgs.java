package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class IdentityArgs {
    public String getWhileColor() {
        return whileColor;
    }

    public String getBlackColor() {
        return blackColor;
    }

    @Parameter(names={"--white"},
            description="Color is white",
            required=true)
    private String whileColor;

    @Parameter(names={"--black"},
            description="Color is white",
            required=true)
    private String blackColor;

}
