package PhantomJs.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.setProperty("phantomjs.binary.path","D:\\Udemy\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setJavascriptEnabled(true);
//        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\Udemy\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//        //capabilities.setCapability(PhantomJSDriverService.);
        WebDriver driver = new PhantomJSDriver();

        driver.get("https://www.linkedin.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for(WebElement element : links){
            System.out.println(element);
        }


    }
}
