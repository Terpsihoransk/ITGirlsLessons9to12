
// Напиши код, который мог бы копировать строку из одного файла в другой.

import java.io.*;

public class IoNioClass {
    public static void main(String[] args) {
        String sourceFilePath = "C://Users/Admin/IdeaProjects/ITGirlsLessons9to12/file.txt";
        String destinationFilePath = "C://Users/Admin/IdeaProjects/ITGirlsLessons9to12/file2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
