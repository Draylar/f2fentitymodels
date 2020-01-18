package main.com.github.draylar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

class FileReader {

    /**
     * Returns the contents of the given {@link File} as a {@link List}.
     * <p>
     * If the File isn't found or can't be read, an {@link IOException} is thrown and an empty list is returned.
     *
     * @param file  a file with data to convert to a list
     * @return  file split into a list.
     */
    List<String> getLines(File file) {
        try {
            return Files.readAllLines(Paths.get(String.valueOf(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
