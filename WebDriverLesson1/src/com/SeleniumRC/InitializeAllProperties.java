package com.SeleniumRC;

import com.SeleniumByAli.InitializeAllPropertiesBeforeTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class InitializeAllProperties{

    //WebDriver _driver;
    HashMap<String, String> propertiesList = new HashMap<>();
    public InitializeAllProperties() throws Exception {
        //propertiesList = returnSettings();
        System.setProperty("webdriver.gecko.driver","D:\\Udemy\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","D:\\Udemy\\chromedriver_win32\\chromedriver.exe");
        //new InitializeAllPropertiesBeforeTest(driver, propertiesList);

    }

    public HashMap<String, String> returnSettings(){
        HashMap<String, String> listOfSettings = new HashMap<>();

        listOfSettings.put("firefox","D:\\Udemy\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        listOfSettings.put("chrome","D:\\Udemy\\chromedriver_win32\\chromedriver.exe");

        return listOfSettings;
    }

}
