package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A Util Class to store {@code readSummary} static method, its unique purpose
 * is to read the scientific summaries on a text file, following the proposed
 * structure in {@code summaryStructure.txt}.
 *
 * @author Arístides Pérez
 * @see
 * <a href="https://github.com/Aristides-19/SciHashTable/blob/main/summaryStructure.txt">Summary
 * File Structure in Github</a>
 */
public class FileController {

    private static enum State {
        TITLE, AUTHORS, BODY, KEYWORDS, NONE
    }

    /**
     * It reads the summary by parts. The array returned is ordered by
     * {@code [Title 0, Authors 1, Body 2, Keywords 3]}, so authors {@code 1}
     * and keywords {@code 3} must be splited by a comma
     * {@code String.split(",")}. NOTE : It can return a {@code null} value if a
     * element from the summary is empty, you must verify the text file or
     * handle an exception.
     *
     * @param path path where the text file is located
     * @return an array of strings with each summary element
     */
    public static String[] readSummary(String path) {
        String title = "", authors = "", body = "", keywords = "";

        try {
            File file = new File(path);

            try (Scanner reader = new Scanner(file)) {
                State e = State.NONE;
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    switch (line) {
                        case "/title" ->
                            e = State.TITLE;
                        case "/authors" ->
                            e = State.AUTHORS;
                        case "/body" ->
                            e = State.BODY;
                        case "/keywords" ->
                            e = State.KEYWORDS;
                    }

                    switch (e) {
                        case State.TITLE ->
                            title += !line.isBlank() && title.isBlank() && !line.equals("/title") ? line : "";
                        case State.AUTHORS ->
                            authors += !line.isBlank() && !line.equals("/authors") ? line + "," : "";
                        case State.BODY ->
                            body += !line.isBlank() && !line.equals("/body") ? line + " " : "";
                        case State.KEYWORDS ->
                            keywords += !line.isBlank() && !line.equals("/keywords") ? line + "," : "";
                    }
                }

                return title.isBlank() || authors.isBlank() || body.isBlank() || keywords.isBlank() ? null
                        : new String[]{title, authors, body, keywords};
            }
        } catch (FileNotFoundException e) {

        }
        return null;
    }
}
