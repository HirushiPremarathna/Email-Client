package Assesment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void reader() {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader("clientList.txt");
            bufferedReader = new BufferedReader(fileReader);
            String newRecord = null;
            while ((newRecord = bufferedReader.readLine()) != null)
                RecipientObjCreator.createObjects(newRecord);
        }
        catch(FileNotFoundException fileNotFoundException) {
            fileNotFoundException.getMessage();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
