package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"src.main.java.utils.Listener"},
        glue = {"src/main/java/steps"},
        features = {"src/test/resources/"},
        tags = "@firstTest"
)

public class CucumberRunner {
}
