package main.com.github.draylar;

import java.util.ArrayList;

class ArrayLogger {

    /**
     * Prints each line in the {@link ArrayList} to the console.
     *
     * @param list  array to print to console
     */
    void log(final ArrayList<String> list) {
        list.forEach(System.out::println);
    }
}
