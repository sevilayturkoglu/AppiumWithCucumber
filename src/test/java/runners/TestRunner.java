package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(//Junit i bu annotationlari kullanmak  icin dependency ediyoruz
        plugin = {"pretty",
                "json:target/cucumber.json",},
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@wip",
        dryRun = false
)
public class TestRunner {

}
