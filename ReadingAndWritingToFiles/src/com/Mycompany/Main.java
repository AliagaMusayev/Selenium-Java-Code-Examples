package com.Mycompany;

import java.io.*;
import java.util.Dictionary;
import java.util.Map;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String,String> logFilesPath = new Map<String, String>();
        String filePath = System.getProperty("user.dir") + "" + "\\src\\config";
        System.out.println(System.getProperty("user.dir"));


        FileInputStream configFile = new FileInputStream((System.getProperty("user.dir") + "" + "\\src\\config\\config.properties"));
        Properties configProperties = new Properties();
        configProperties.load(configFile);



        Properties prop = new Properties();
        File f = new File((System.getProperty("user.dir") + "" + "\\src\\config\\config.properties"));
        if(f.exists()){
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "" + "\\src\\config\\config.properties");
            try{

                prop.load(file);

                System.out.println(prop.getProperty("name"));
            }
            catch (FileNotFoundException ex){
                System.out.println(ex.getMessage());
            }

            catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            finally {
                file.close();
            }
        }

        File txtFile = new File((System.getProperty("user.dir") + "" + "\\src\\config\\test.txt"));
        if(!txtFile.exists()){
            txtFile.createNewFile();
        }
        FileWriter writer = new FileWriter(txtFile,true);
        //BufferedWriter wr = new BufferedWriter(writer);
        writer.write("test completed\n");

        writer.close();
        System.out.println("Completed");

        System.out.println("Reading info from file");

        ReadingFileContent read = new ReadingFileContent();
        read.readFileContentAndPrint(filePath,"test.txt");

    }
}
