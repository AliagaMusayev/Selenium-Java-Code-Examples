import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Initializer {

    @BeforeSuite()
    public void InitializeAllProperties(){

    }

    @AfterSuite
    public void DestructAllProperties(){

    }
}
