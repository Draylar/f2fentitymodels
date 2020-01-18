package main.com.github.draylar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

class FileReader {
    /**
     * Retrieves the lines in a file and returns it as a List<String>.
     * Returns an empty list if no lines are found.
     *
     * @param file location of file to be read
     * @return a list of lines found in the file
     */
    List<String> getLines(File file) {
        try {
            return Files.readAllLines(Paths.get(String.valueOf(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.singletonList("");
    }
}
