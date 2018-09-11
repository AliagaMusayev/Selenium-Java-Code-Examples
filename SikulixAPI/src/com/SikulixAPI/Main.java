package com.SikulixAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, FindFailed {

        System.setProperty("webdriver.gecko.driver", "D:\\Udemy\\GeckoAndChromeDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\GeckoAndChromeDriver\\chromedriver_win32\\chromedriver.exe");


        WebDriver driver = new FirefoxDriver();
        driver.get("https://smallpdf.com/pdf-to-word");
        //driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,20L);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Choose file')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Choose file')]")).click();

        uploadFile();

    }

    public static void uploadFile() throws FindFailed, InterruptedException {
        Screen screen = new Screen();
        Pattern patternSearch = new Pattern("C:\\Users\\aliaga.musayev\\Desktop\\loc.jpg");
        Pattern openButton = new Pattern("C:\\Users\\aliaga.musayev\\Desktop\\open.jpg");

        screen.wait(patternSearch,10);
        screen.type(patternSearch,"C:\\Users\\aliaga.musayev\\Desktop\\test.txt");

        screen.wait(openButton,10);
        screen.click(openButton);

    }
}
