package main.com.github.draylar;

import java.util.ArrayList;

class ClassLogger {
    /**
     * Log each line in the ArrayList.
     * Used for printing out converted classes.
     *
     * @param logList converted class lines
     */
    void log(final ArrayList<String> logList) {
        logList.forEach(System.out::println);
    }
}
