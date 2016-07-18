import listener.testListener;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */

@Listeners(testListener.class)
public class CalculateDivTest extends BaseTest {

    @Test (dataProvider = "positiveDiv", groups = "positive")
    public void positiveDivTest(long a, long b, long res){
        long result = calculator.div(a, b);
        Assert.assertEquals(result, res, "positiveDivTest failed");
        System.out.println("positiveDivTest passed for: " + "{" + a + "}" + "{" + b + "}" + "{" + res + "}");
    }

    @Test (dataProvider = "negativeDiv", groups = "negative")
    public void negativeDivTest(long a, long b, long res){
        long result = calculator.div(a, b);
        Assert.assertNotSame(result, res, "negativeDivTest failed");
        System.out.println("negativeDivTest passed for: " + "{" + a + "}" + "{" + b + "}" + "{" + res + "}");
    }

    @DataProvider (name = "positiveDiv")
    public Object[][] getValues(){
        return new Object[][] {
                {10, 5, 2},
                {-6, 2, -3},
                {0, 4 , 0}
        };
    }

    @DataProvider (name = "negativeDiv")
    public Object[][] getNegValues(){
        return new Object[][] {
                {10, 5, 3},
                {-6, 5, -3},
                {0, 4 , 1}
        };
    }

    @BeforeTest
    public void setUp(){
        System.out.printf("\n@BeforeTest CalculateDivTest class method runs\n");
    }

    @AfterTest
    public void tearDown(){
        System.out.printf("\n@AfterTest CalculateDivTest class method runs\n");
    }
}
