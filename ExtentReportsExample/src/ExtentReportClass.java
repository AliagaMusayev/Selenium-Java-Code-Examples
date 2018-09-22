import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExtentReportClass {
    ExtentReports reports = new ExtentReports("Reports\\myReports.html",true);
    ExtentTest test;

    @Test
    public void Login(){
        test = reports.startTest("Testing Login method");
        //reports.startReporter(ReporterType.DB,"Reports\\myReports.html");

        System.out.println("Success");

        test.log(LogStatus.PASS,"Passed");

        reports.endTest(test);

        reports.flush();
    }

    @Test(dependsOnMethods = "Login")
    public void CheckTitle(){
        test = reports.startTest("Testing Login method");
        //reports.startReporter(ReporterType.DB,"Reports\\myReports.html");

        System.out.println("Success title");

        test.log(LogStatus.PASS,"Passed");

        reports.endTest(test);

        reports.flush();
    }


    @Test(dependsOnMethods = "CheckTitle")
    public void Logout(){
        test = reports.startTest("Testing Login method");
        //reports.startReporter(ReporterType.DB,"Reports\\myReports.html");

        System.out.println("Failed logout");
        try {
            int a = 10/0;
        }
        catch (Exception ex)
        {
            test.log(LogStatus.FAIL,"Failed: "+ex.getMessage());
        }


        reports.endTest(test);

        reports.flush();
    }

    @BeforeSuite
    public void InitializeAllProperties(){

    }

    @AfterSuite
    public void TearDownAllProperties(){

    }

}
