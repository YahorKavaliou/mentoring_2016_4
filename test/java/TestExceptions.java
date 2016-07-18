import listener.testListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Yahor_Kavaliou on 7/14/2016.
 */

@Listeners(testListener.class)
public class TestExceptions extends BaseTest {

    @Test (dataProvider = "divByZeroException", groups = "exceptions", expectedExceptions = {NumberFormatException.class})
    public void divByZero(long a){
        long res = calculator.div(a, 0l);
        System.out.println("divByZero passed");
        System.out.println("divByZero passed for: " + "{" + a + "}");
    }

/*    @Test (dataProvider = "sqrtFromNegative", groups = "exceptions")
    public void wrongInputData(long a){
        double res = calculator.sqrt(a);
    }*/


    @DataProvider(name = "divByZeroException")
    public Object[][] getValues1(){
        return new Object[][] {
                {3},{-5},{0}
        };
    }

    @DataProvider(name = "sqrtFromNegative")
    public Object[][] getValues2(){
        return new Object[][] {
                {-5}, {-42}, {-100}
        };
    }
}
