import listener.testListener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */

@Listeners(testListener.class)
public class CalculateSquareTest extends BaseTest {

    @Test(dataProvider = "positiveSqr", groups = "positive")
    public void positiveSqrTest(double a,  double res){
        double result = calculator.sqrt(a);
        try {
            System.out.println(new Date().toString());
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
        Assert.assertEquals(result, res, "positiveSqrTest failed");
    }

    @Test (dataProvider = "negativeSqr", groups = "negative")
    public void negativeSqrTest(double a, double res){
        double result = calculator.sqrt(a);
        Assert.assertNotSame(result, res, "negativeSqrTest failed");
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

    }

    @AfterTest
    public void tearDown(){

    }
}
