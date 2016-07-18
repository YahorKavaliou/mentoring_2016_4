import listener.testListener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */

@Listeners(testListener.class)
public class CalculateSumTest extends BaseTest {

    @Test (dataProvider = "positiveSum", groups = "positive")
    public void positiveSumTest(long a, long b, long res){
        long result = calculator.sum(a, b);
        try {
            System.out.println(new Date().toString());
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
        Assert.assertEquals(result, res, "positiveSumTest failed");
    }

    @Test (dataProvider = "negativeSum", groups = "negative")
    public void negativeSumTest(long a, long b, long res){
        long result = calculator.sum(a, b);
        Assert.assertNotSame(result, res, "negativeSumTest failed");
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

    }

    @AfterTest
    public void tearDown(){

    }
}
