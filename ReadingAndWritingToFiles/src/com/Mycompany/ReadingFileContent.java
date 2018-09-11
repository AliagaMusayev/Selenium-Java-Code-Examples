package com.Mycompany;

import java.io.*;

public class ReadingFileContent {

    public void readFileContentAndPrint(String filePath, String fileName) throws IOException {
        filePath = filePath + "\\"+fileName;
        File myFile;
        FileReader reader;
        BufferedReader read = null;
        try {
            myFile = new File(filePath);
            reader = new FileReader(myFile);
            read = new BufferedReader(reader);
            String fileContent = null;

            if(myFile.exists()){
                while ((fileContent=read.readLine())!=null){
                    System.out.println(read.readLine());
                }
            }

            else {
                System.out.println("There is no any file with this name");
            }
        }

        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            read.close();
        }
    }
}
