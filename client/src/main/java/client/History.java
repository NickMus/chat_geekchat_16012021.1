package client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class History {
    private static PrintWriter pr;

    public static String createHistoryFile(String login) {
        return "client/src/History/" + "history_" + login + ".txt";
    }

    public static void addToHistory(String login) {
        try {
            pr = new PrintWriter(new FileOutputStream(createHistoryFile(login), true), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveHistory(String text) {
        pr.println(text);
    }

    public static String loadHistory(String login) {

        StringBuilder sb = new StringBuilder();
        try {
            List<String> hist = Files.readAllLines(Paths.get(createHistoryFile(login)));
            int count = 0;
            if (hist.size() > 100) {
                count = hist.size() - 100;
            }
                for (int i = count; i < hist.size(); i++) {
                    sb.append(hist.get(i)).append(System.lineSeparator());
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }


}
