import org.junit.*;


public class Tes1 {

    @BeforeClass
    public void testDBConnection(){
        System.out.println("Checking DB connection !!!");
        Assume.assumeTrue(isDBConnectionAvailable());
    }

    @Before
    public void BeforeTest(){
        System.out.println("Before Test");
    }

    @Test
    public void Test1(){
        System.out.println("Test started");
    }

    @After
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    public boolean isDBConnectionAvailable(){
        return true;
    }

}
