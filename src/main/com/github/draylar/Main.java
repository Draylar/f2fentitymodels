package main.com.github.draylar;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner INPUT_SCANNER = new Scanner(System.in);
    private static final LineConverter LINE_CONVERTER = new LineConverter();
    private static final FileReader FILE_READER = new FileReader();
    private static final ArrayLogger LOGGER = new ArrayLogger();

    public static void main(String[] args) {
        File file;

        if (args.length > 0) {
            file = new File(args[0]);
        } else {
            System.out.println("Enter the path of the file you want to convert: ");
            file = new File(INPUT_SCANNER.nextLine());
        }

        // log output
        System.out.println("Formatted class: ");
        LOGGER.log(getFormattedLines(file));
    }

    /**
     * Converts the contents read from a {@link File} to formatted and split lines.
     *
     * @param file  file location to read data from
     * @return   a list of formatted lines parsed from the data
     */
    private static ArrayList<String> getFormattedLines(File file) {
        ArrayList<String> lines = new ArrayList<>(FILE_READER.getLines(file));

        ArrayList<String> formattedLines = new ArrayList<>();
        lines.forEach(line -> formattedLines.add(LINE_CONVERTER.convertLine(line)));

        return formattedLines;
    }
}
