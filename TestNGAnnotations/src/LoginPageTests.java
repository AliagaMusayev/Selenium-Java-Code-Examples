import CustomExceptions.LoginCredentialsException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class LoginPageTests {

    @Test(dataProviderClass = BaseClass.class, dataProvider = "pr1")
    public void Login(String username, String password) throws LoginCredentialsException {
        if(username==null || password==null)
            throw new LoginCredentialsException("Either username nor password can be null");

        //fail("Failed");
        System.out.println(username + " : "+ password);
    }

    @Test(dependsOnMethods = "Login")
    public void MainPageTitle(){
        System.out.println("Main page title is Success");
    }
}
