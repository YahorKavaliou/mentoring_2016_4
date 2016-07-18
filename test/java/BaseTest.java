import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Yahor_Kavaliou on 7/13/2016.
 */
public class BaseTest {
    protected Calculator calculator;

    BaseTest(){
        calculator = new Calculator();
    }

    @BeforeTest
    public void setUpBase(){
        System.out.printf("\n@BeforeTest base class method runs\n");
    }

    @AfterTest
    public void tearDownBase(){
        System.out.printf("\n@AfterTest base class method runs\n");
    }
}
