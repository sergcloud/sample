package sergcloud.sample.io;

import java.io.*;

public class NumerationLines {
    private static final String TEXT_FILENAME_FROM = "d://in.txt";
    private static final String TEXT_FILENAME_TO = "d://out.txt";
    private static final String FILE_ENCODING = "cp1251";
    private static final String LINE_NUMBER_DELIMITER = ". ";

    private static BufferedReader reader;
    private static Writer writer;
    private static String line;

    public static void main(String[] args) {
        addLineNumbers();
    }

    public static void addLineNumbers() {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(TEXT_FILENAME_FROM), FILE_ENCODING));
            writer = new FileWriter(TEXT_FILENAME_TO);

            int linesCounter = 0;
            while ((line = reader.readLine()) != null) {
                linesCounter++;
                writer.write(linesCounter + LINE_NUMBER_DELIMITER + line + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReaderWriter(reader, writer);
        }
    }

    private static void closeReaderWriter(Reader reader, Writer writer) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
