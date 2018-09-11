package com.Profiles;

import com.SeleniumByAli.BaseClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ProfilesIni profiles = new ProfilesIni();



        FirefoxProfile firefoxProfile = profiles.getProfile("Selenium");
        firefoxProfile.setAcceptUntrustedCertificates(true);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(firefoxProfile);
        System.setProperty("webdriver.gecko.driver","D:\\Udemy\\GeckoAndChromeDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","D:\\Udemy\\GeckoAndChromeDriver\\chromedriver_win32\\chromedriver.exe");

        WebDriver _driver = new FirefoxDriver(options);

        BaseClass<FirefoxDriver> myBase = new BaseClass(_driver);
        myBase.gotoURL("http://www.asoa-group.com");
        _driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);
    }
}
