package com.JqueryCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    private static int $;
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {


        System.setProperty("webdriver.gecko.driver", "D:\\Udemy\\GeckoAndChromeDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Udemy\\GeckoAndChromeDriver\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.id("datepicker")).click();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);

        for (int i=0;i<3;i++){
            WebElement next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
            Thread.sleep(1000);
            next.click();
        }

        driver.findElement(By.linkText("4")).click();

        Parent p1 = new Parent();
        p1.i=10;
        p1.j=20;

        Parent p2 = (Parent) p1.clone();
    }
}

class Parent{
    int i, j;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Child{

}
