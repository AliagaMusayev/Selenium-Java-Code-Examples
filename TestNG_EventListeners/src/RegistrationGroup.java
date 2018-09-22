import org.testng.annotations.Test;

public class RegistrationGroup extends TestEventListener{

    @Test(groups = "BaseGroup")
    public void FillForm(){
        System.out.println("Form filled out");
    }
}
