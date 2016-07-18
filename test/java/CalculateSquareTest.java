import listener.testListener;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */

@Listeners(testListener.class)
public class CalculateSquareTest extends BaseTest {

    @Test(dataProvider = "positiveSqr", groups = "positive")
    public void positiveSqrTest(double a,  double res){
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, res, "positiveSqrTest failed");
        System.out.println("positiveSqrTest passed for: " + "{" + a + "}" + "{" + res + "}");
    }

    @Test (dataProvider = "negativeSqr", groups = "negative")
    public void negativeSqrTest(double a, double res){
        double result = calculator.sqrt(a);
        Assert.assertNotSame(result, res, "negativeSqrTest failed");
        System.out.println("negativeSqrTest passed for: " + "{" + a + "}" + "{" + res + "}");
    }

    @DataProvider(name = "positiveSqr")
    public Object[][] getValues(){
        return new Object[][] {
                {100, 10},
                {4, 2},
                {9, 3}
        };
    }

    @DataProvider (name = "negativeSqr")
    public Object[][] getNegValues(){
        return new Object[][] {
                {10, 3},
                {-6, 5},
                {0, 4}
        };
    }

    @BeforeTest
    public void setUp(){
        System.out.printf("\n@BeforeTest CalculateSquareTest class method runs\n");
    }

    @AfterTest
    public void tearDown(){
        System.out.printf("\n@AfterTest CalculateSquareTest class method runs\n");
    }
}
