package main.com.github.draylar;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static final Scanner INPUT = new Scanner(System.in);
    private static final LineConverter CONVERTER = new LineConverter();
    private static final FileReader READER = new FileReader();
    private static final ClassLogger LOGGER = new ClassLogger();
    private static final IOPrompter PROMPTER = new IOPrompter();

    public static void main(String[] args)
    {
        // prompt for file location
        PROMPTER.prompt(IOPrompter.ProgramStage.FILE);
        File file = new File(INPUT.nextLine());

        // log output
        PROMPTER.prompt(IOPrompter.ProgramStage.OUTPUT);
        LOGGER.log(getFormattedLines(file));
    }

    /**
     * Takes a file and returns it as a list of formatted lines.
     * @param file file location
     * @return list of formatted lines
     */
    private static ArrayList<String> getFormattedLines(File file)
    {
        ArrayList<String> lines = new ArrayList<>(READER.getLines(file));
        ArrayList<String> formattedLines = new ArrayList<>();

        lines.forEach(line -> formattedLines.add(CONVERTER.convertLine(line)));
        return formattedLines;
    }
}
