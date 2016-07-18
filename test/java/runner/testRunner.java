package runner;

import listener.testListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yahor_Kavaliou on 7/14/2016.
 */
public class testRunner {
    public static void main(String[] ergs){
        TestListenerAdapter testListenerAdapter = new TestListenerAdapter();
        TestNG testNG = new TestNG();
        testNG.addListener(testListenerAdapter);
        testNG.addListener(new testListener());

        XmlSuite suite = new XmlSuite();
        suite.setName("allTestsSuite");

        List<String> files = new ArrayList<String>();
        files.addAll(new ArrayList<String>(){{
            add(".\\test\\java\\suites\\allTestsRunner.xml");
            add(".\\test\\java\\suites\\negativeTestsRunner.xml");
            add(".\\test\\java\\suites\\positiveTestsRunner.xml");
        }});
        suite.setSuiteFiles(files);
        suite.setParallel(XmlSuite.PARALLEL_METHODS);
        suite.setThreadCount(2);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        testNG.setXmlSuites(suites);

        testNG.run();
    }
}
