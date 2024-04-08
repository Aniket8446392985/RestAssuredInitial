package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/Features/",
        glue = "StepDefn",
        monochrome = true,
        plugin = {"pretty","html:target/Post_Request_hmtlreport.html"}
)
public class PostRequestRunner
{

}
