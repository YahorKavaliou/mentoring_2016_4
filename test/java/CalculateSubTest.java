import listener.testListener;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */

@Listeners(testListener.class)
public class CalculateSubTest extends BaseTest {

    @Test (dataProvider = "positiveSub", groups = "positive")
    public void positiveSubTest(long a, long b, long res){
        long result = calculator.sub(a, b);
        try {
            System.out.println(new Date().toString());
            Thread.sleep(1000);
        } catch (InterruptedException e) { }
        Assert.assertEquals(result, res, "positiveSubTest failed");
    }

    @Test (dataProvider = "negativeSub", groups = "negative")
    public void negativeSubTest(long a, long b, long res){
        long result = calculator.sub(a, b);
        Assert.assertNotSame(result, res, "negativeSubTest failed");
    }

    @DataProvider(name = "positiveSub")
    public Object[][] getValues(){
        return new Object[][] {
                {-5, -3, -2},
                {4, 1, 3},
                {0, 4 , -4}
        };
    }

    @DataProvider(name = "negativeSub")
    public Object[][] getNegValues(){
        return new Object[][] {
                {-5, -3, -3},
                {4, 1, 2},
                {0, 4 , -2}
        };
    }

    @BeforeTest
    public void setUp(){

    }

    @AfterTest
    public void tearDown(){

    }
}
