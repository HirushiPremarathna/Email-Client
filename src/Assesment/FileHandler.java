package Assesment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    //handling the operation of writing file

    public static void writeFile(String information) {

        BufferedWriter bufferedWriter = null;
        try {

            File file = new File("clientList.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(information + "\n");


        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
