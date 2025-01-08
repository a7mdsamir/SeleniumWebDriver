package runner;

//import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@CucumberOptions(features="src/test/java/features"
        ,glue= {"steps"}
        ,plugin= {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase
{


}
