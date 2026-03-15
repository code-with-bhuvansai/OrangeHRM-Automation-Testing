package runner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    // Path to your Feature file(s)
    features = "src/test/resources/features/addnationalitiy.feature", 
    
    
    glue = "Stepdefinition", 
    
    // Plugins for reporting (Console output, HTML report, JSON report)
    plugin = {
        "pretty",                                   // Prints Gherkin steps in console
        "html:target/cucumber-reports/report.html", // Generates an HTML report
        "json:target/cucumber-reports/report.json"  
    },
    
    // Makes console output readable 
    monochrome = true

)
public class TestRunner {
    
}
