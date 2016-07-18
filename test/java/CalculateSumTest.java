import listener.testListener;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */

@Listeners(testListener.class)
public class CalculateSumTest extends BaseTest {

    @Test (dataProvider = "positiveSum", groups = "positive")
    public void positiveSumTest(long a, long b, long res){
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, res, "positiveSumTest failed");
        System.out.println("positiveSumTest passed for: " + "{" + a + "}" + "{" + b + "}" + "{" + res + "}");
    }

    @Test (dataProvider = "negativeSum", groups = "negative")
    public void negativeSumTest(long a, long b, long res){
        long result = calculator.sum(a, b);
        Assert.assertNotSame(result, res, "negativeSumTest failed");
        System.out.println("negativeSumTest passed for: " + "{" + a + "}" + "{" + b + "}" + "{" + res + "}");
    }

    @DataProvider(name = "positiveSum")
    public Object[][] getValues(){
        return new Object[][] {
                {1, 2, 3},
                {-4, 6, 2},
                {0, -1 , -1}
        };
    }

    @DataProvider(name = "negativeSum")
    public Object[][] getNegValues(){
        return new Object[][] {
                {1, 2, 4},
                {-4, 6, 4},
                {0, -1 , -2}
        };
    }

    @BeforeTest
    public void setUp(){
        System.out.printf("\n@BeforeTest CalculateSumTest class method runs\n");
    }

    @AfterTest
    public void tearDown(){
        System.out.printf("\n@AfterTest CalculateSumTest class method runs\n");
    }
}
