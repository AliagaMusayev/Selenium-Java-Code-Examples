package com.SeleniumRC;

import com.SeleniumByAli.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {

    static WebDriver _driver;


    public static void main(String[] args) throws Exception {
        new InitializeAllProperties();
        _driver = new FirefoxDriver();
        BaseClass<WebDriver> baseClass = new BaseClass<>((FirefoxDriver) _driver);

        //GeckoDriverService service = new GeckoDriverService("D:\\Udemy\\geckodriver-v0.21.0-win64\\geckodriver.exe");

//        WebDriver _driver = new FirefoxDriver();
//        _driver.get("https://accounts.google.com");

//         _driver = new ChromeDriver();
//         // Open url in seperate blank page
//        _driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
//        _driver.get("https://accounts.google.com");
//
//        // get browser name and version or another about browser
//        Capabilities capabilities = ((RemoteWebDriver)_driver).getCapabilities();
//        System.out.println(capabilities.getBrowserName() + " => " + capabilities.getVersion());
//
//        // Scrolling
//        setWindowSize(350,350);
//        JavascriptExecutor executor = (JavascriptExecutor)_driver;
//        executor.executeScript("scrollBy(0,2500)");
//
//        URI uri = new URI(_driver.getCurrentUrl());
//        System.out.println(uri.getHost());
//
//
//        //Cookies
//
//        Set <Cookie> cookieList = _driver.manage().getCookies();
//
//        for(Cookie cookie: cookieList){
//            System.out.println(cookie.getName());
//            _driver.manage().deleteCookie(cookie);
//        }
//
//
//        _driver.quit();

        baseClass.gotoURL("https://accounts.google.com");
        baseClass.waitWhileWebPageCompletelyReady(30);
        baseClass.SendKeysInSelectedTextField("aliaghamusayev@gmail.com", By.id("identifierId"));
        baseClass.clickButton(By.xpath("//span[contains(text(),'Next')]"));

    }


    public static void InitializePropertiesBeforeTest() throws Exception {
        new InitializeAllProperties();
    }

    public static void setWindowSize(int width, int height){

        Dimension dimension = new Dimension(width,height);

        _driver.manage().window().setSize(dimension);

    }


}
