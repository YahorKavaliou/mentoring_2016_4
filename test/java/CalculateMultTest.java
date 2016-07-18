import listener.testListener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */

@Listeners(testListener.class)
public class CalculateMultTest extends BaseTest {

    @Test (dataProvider = "positiveMult", groups = "positive")
    public void positiveMultTest(long a, long b, long res){
        long result = calculator.mult(a, b);
        try {
            System.out.println(new Date().toString());
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
        Assert.assertEquals(result, res, "positiveMultTest failed");
    }

    @Test (dataProvider = "negativeMult", groups = "negative")
    public void negativeMultTest(long a, long b, long res){
        long result = calculator.mult(a, b);
        Assert.assertNotSame(result, res, "negativeMultTest failed");
     }

    @DataProvider(name = "positiveMult")
    public Object[][] getValues(){
        return new Object[][] {
                {2, 3, 6},
                {-3, 6, -18},
                {1, 0 , 0}
        };
    }

    @DataProvider(name = "negativeMult")
    public Object[][] getNegValues(){
        return new Object[][] {
                {2, 3, 5},
                {-3, 6, -20},
                {1, 0 , 1}
        };
    }

    @BeforeTest
    public void setUp(){

    }

    @AfterTest
    public void tearDown(){

    }
}
