import org.testng.annotations.Test;

public class LoginGroup extends TestEventListener{

    @Test(groups = "Login", priority = 2)
    public void Login(){
        System.out.println("Logged in");
    }


    @Test(groups = "Login", priority = 3)
    public void CheckTitleOfPage(){
        System.out.println("Title is true");
    }

    @Test(groups = "Login", priority = 4)
    public void LogOut(){
        System.out.println("Logged out");
    }

    @Test(groups = "Inject", priority = 1)
    public void SQLInject(){
        System.out.println("Injection was not successfully");
    }
}
