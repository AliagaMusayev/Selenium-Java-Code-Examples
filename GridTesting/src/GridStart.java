import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GridStart {
    public static void main(String args[]) throws MalformedURLException, InterruptedException {
//        System.setProperty("webdriver.gecko.driver","D:\\Udemy\\GeckoAndChromeDriver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
//        FirefoxOptions options = new FirefoxOptions();
//        options.setCapability(CapabilityType.BROWSER_NAME,"firefox");
//        options.setCapability(CapabilityType.PLATFORM_NAME, "ANY");
//
//        RemoteWebDriver _driver = new RemoteWebDriver(new URL("http://192.168.135.90:4444/wd/hub"), options);
//        _driver.get("https://docs.seleniumhq.org/download/");
//
//        _driver.manage().timeouts().implicitlyWait(5L,TimeUnit.SECONDS);
//        _driver.quit();

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.BROWSER_NAME,"firefox");
        options.setCapability(CapabilityType.PLATFORM_NAME, "ANY");

        Thread th1 = new Thread(()->{


            RemoteWebDriver _driver = null;
            try {
                _driver = new RemoteWebDriver(new URL("http://192.168.135.90:4444/wd/hub"), options);
                //_driver.get("https://docs.seleniumhq.org/download/");

                _driver.manage().timeouts().implicitlyWait(5L,TimeUnit.SECONDS);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            finally {
                _driver.quit();
                System.out.println("Thread 1 executed");
            }

        });


        Thread th2 = new Thread(()->{
//            FirefoxOptions options = new FirefoxOptions();
//            options.setCapability(CapabilityType.BROWSER_NAME,"firefox");
//            options.setCapability(CapabilityType.PLATFORM_NAME, "ANY");

            RemoteWebDriver _driver = null;
            try {
                _driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                //_driver.get("https://docs.seleniumhq.org/download/");

                _driver.manage().timeouts().implicitlyWait(5L,TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            finally {
                _driver.quit();
                System.out.println("Thread 2 executed");
            }

        });

        //th1.start();
        th1.start();
        th2.start();
        th2.join();

    }
}
