import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class BaseClass {

    @DataProvider(name = "pr1")
    public Object[][] LoginData(Method methodName){
        Object[][] obj=null;

        if(methodName.getName().equals("Login")){
            obj = new Object[1][2];

            obj[0][0] = "Aliaga";
            obj[0][1] = "p@ssw0rd";
        }

        return  obj;
    }
}
