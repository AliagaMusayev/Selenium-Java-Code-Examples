package com.Listeners;

import com.SeleniumByAli.BaseClass;
import com.SeleniumByAli.CustomExceptions.CookieUnavailableException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;


public class Main{

    public static void main(String[] args) {
        ProfilesIni profiles = new ProfilesIni();
        FirefoxProfile firefoxProfile = profiles.getProfile("Selenium");
        firefoxProfile.setAcceptUntrustedCertificates(true);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(firefoxProfile);
        System.setProperty("webdriver.gecko.driver","D:\\Udemy\\GeckoAndChromeDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","D:\\Udemy\\GeckoAndChromeDriver\\chromedriver_win32\\chromedriver.exe");

        WebDriver _driver = new FirefoxDriver(options);



        EventFiringWebDriver driver = new EventFiringWebDriver(_driver);
        EventListener listener = new EventListener();
        driver.register(listener);
        BaseClass<FirefoxDriver> myBase = new BaseClass(driver,true);
        myBase.gotoURL("https://accounts.google.com");
        driver.manage().timeouts().implicitlyWait(20L,TimeUnit.SECONDS);

        HashSet<Cookie> cookies;
        try {
            cookies = myBase.getAllCookies();
            for (Cookie cookie : cookies){
                System.out.println(cookie.getName());
            }
            System.out.println("....Cookies available..... -> " + cookies);
        } catch (CookieUnavailableException e) {
            e.printStackTrace();
        }

        // Mouse events
        EventFiringMouse mouseEvents = new EventFiringMouse(driver,listener);
        Locatable locate = (Locatable) driver.findElement(By.xpath("//a[contains(text(),'Projects')]"));
        Coordinates coordinates = locate.getCoordinates();

        mouseEvents.mouseMove(coordinates);

        System.out.println(myBase.AssertResult(10,20));
        System.out.println(myBase.AssertResult("aaa","aaa"));
        //myBase.AssertTrue(10,30);

        try{
            Thread.sleep(5000L);
            driver.findElement(By.xpath("//a[contains(text(),'Interior design')]")).click();
        }
        catch (Exception ex){

        }

        myBase.FocusOn(myBase.GetSelectedWindowByIndex(2));

    }
}
