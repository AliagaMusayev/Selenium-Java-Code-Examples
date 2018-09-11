package com.Mycompany;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Map;
import java.util.Properties;

public class InitializeConfigurations {

    public Map<String,String> returnConfigSettings(Map<String,String> settingsDict) throws IOException {

        FileInputStream configFile=null;
        Properties configProperties = null;
        File confFile;
        try{
             configFile = new FileInputStream((System.getProperty("user.dir") + "" + "\\src\\config\\config.properties"));
             configProperties = new Properties();
             confFile = new File(String.valueOf(configFile));
            if(confFile.exists()){
                configProperties.load(configFile);
                settingsDict.put("ErrorFilesPath",configProperties.getProperty("ErrorLogFilesPath"));
                settingsDict.put("ExecutionFilesPath",configProperties.getProperty("ExecutionLogFilesPath"));
            }

            else{
                throw new FileNotFoundException("There is no any config file");
            }

        }

        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        finally {
            configFile.close();
        }


        return  settingsDict;
    }
}
