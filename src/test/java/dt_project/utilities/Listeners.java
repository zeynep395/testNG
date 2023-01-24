package dt_project.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

  /*
    ITestListener is an interface
    We are using this interface for customizing our testNG framework
    onStart, onFinish, onTestStart, onTestFinish, onTestSuccess, onTestFail, are special method names are used to LISTEN the test methods.
    We especially use listeners for adding a special condition such as test pass, fail or skip.
  */

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart - Excecute ONCE before All test" + context.getName());//getName() methodu ile Test edilen testin ismi gelir.
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish - Excecute ONCE after All test" + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart - Excecute ONCE before EACH @Test" + result.getName());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - Excecute ONCE after EACH PASSED @Test" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure - Excecute ONCE after EACH FAILED @Test" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTeonTestSkippedstFailure - Excecute ONCE after EACH SKIPPED @Test" + result.getName());

    }
}
