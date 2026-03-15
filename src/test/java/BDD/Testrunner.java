package BDD;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/addnationalitiy.feature",
        glue = "BDD",
        monochrome = false,
        plugin = {"pretty"}
)
public class Testrunner {
}
	

