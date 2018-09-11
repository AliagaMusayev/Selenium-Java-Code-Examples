import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(Tes1.class)
public class BaseClass {

    public void StartAllTests(){
       System.out.println("All tests started !!!");
    }
}
