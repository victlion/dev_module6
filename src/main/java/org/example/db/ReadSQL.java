package org.example.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadSQL {
    public String getSQL(String nameFileSQL){
        File file = new File("SQL/" + nameFileSQL);
        StringBuilder textFile = new StringBuilder();

        try(FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis)
        )
        {
            while(scanner.hasNext()){
                textFile.append(scanner.nextLine()).append("\n");
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return textFile.toString();
    }
}
