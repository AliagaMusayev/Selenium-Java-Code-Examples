import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

    protected RemoteWebDriver _driver = null;

    @Test(dataProvider = "returnBrowserInstances")
    public void LoginTest(String browserInstance) throws MalformedURLException {
        switch (browserInstance){


            case "firefox":
               FirefoxOptions options = new FirefoxOptions();
               options.setCapability(CapabilityType.BROWSER_NAME,"firefox");

               try{
                   _driver = new RemoteWebDriver(new URL("http://192.168.135.90:4444/wd/hub"),options);
                   _driver.get("https://docs.seleniumhq.org/download/");

                   String titleOfPage = _driver.getTitle();

                   Assert.assertEquals(titleOfPage,"Downloads");
               }
               catch (Exception ex){
                   System.out.println("Error occured");
               }

               finally {
                   _driver.quit();
               }

               break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME,"chrome");

                try{
                    _driver = new RemoteWebDriver(new URL("http://192.168.135.90:4444/wd/hub"), chromeOptions);
                    _driver.get("https://docs.seleniumhq.org/download/");

                    String titleOfPage = _driver.getTitle();

                    Assert.assertEquals(titleOfPage,"Downloads");
                }

                catch (Exception ex){
                    System.out.println("Error occured");
                }

                finally {
                    _driver.quit();
                }

                break;

//            case "iexplore":
//
//                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
//                internetExplorerOptions.setCapability(CapabilityType.BROWSER_NAME,"iexplore");
//                _driver = new RemoteWebDriver(new URL("http://192.168.135.90:4444/wd/hub"), internetExplorerOptions);
//                break;


                default:
                    System.out.println("There is no such kind of Browser type. Please check browser type again");
        }
    }



    @DataProvider(parallel = true)
    public Object[][] returnBrowserInstances(){
        Object[][] browserCapabilities = new Object[2][1];

        browserCapabilities[0][0] = "firefox";
        browserCapabilities[1][0] = "chrome";
        //browserCapabilities[2][0] = "iexplore";


        return  browserCapabilities;
    }
}
