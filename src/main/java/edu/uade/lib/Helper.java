package edu.uade.lib;

import java.io.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Helper {
    public static Date fromString(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        return format.parse(date);
    }

    public static String fromDate(Date date) {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static void saveToFile(StringBuilder sb, String fileName) throws IOException {
        File file = new File(fileName);
        BufferedWriter writer = null;
        try {
            // false = override file if exist
            writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(sb.toString());
        } finally {
            if (writer != null) writer.close();
        }
    }

    public static List<String> readFile(String filename) {
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }
}
