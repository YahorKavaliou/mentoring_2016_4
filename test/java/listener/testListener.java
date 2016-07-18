package listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Created by Yahor_Kavaliou on 7/15/2016.
 */
public class testListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        System.out.println("method start" + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult){
        System.out.println("method stop" + method.getTestMethod().getMethodName());
    }
}
