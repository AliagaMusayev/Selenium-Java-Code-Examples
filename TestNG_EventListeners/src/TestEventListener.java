import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestEventListener extends TestListenerAdapter {

    public void onTestSuccess(ITestResult var1) {
        System.out.println("Passed method is : " + var1.getName());
    }


}
