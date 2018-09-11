package com.DesiredCapabilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\Udemy\\GeckoAndChromeDriver\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","D:\\Udemy\\GeckoAndChromeDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setAcceptInsecureCerts(true);
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME,"ANY");
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        WebDriver _driver = new FirefoxDriver();


    }
}
