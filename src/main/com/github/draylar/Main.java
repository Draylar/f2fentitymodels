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
        PROMPTER.prompt(IOPrompter.PromptStage.FILE);
        File file = new File(INPUT.nextLine());

        ArrayList<String> lines = new ArrayList<>(READER.getLines(file));
        ArrayList<String> formattedLines = new ArrayList<>();

        lines.forEach(line ->
                formattedLines.add(CONVERTER.convertLine(line)));

        PROMPTER.prompt(IOPrompter.PromptStage.OUTPUT);
        LOGGER.log(formattedLines);
    }
}
