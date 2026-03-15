package Stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class AddNationalitySteps {

    WebDriver driver;

    //Background Steps ---

    @Given("the user is logged in as an Administrator")
    public void the_user_is_logged_in_as_an_administrator() {
        // Setup Driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login Logic
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Given("the user navigates to the {string} configuration page")
    public void the_user_navigates_to_the_configuration_page(String pageName) {
        // Logic to navigate through the menu (Admin - Configuration - Nationalities)
       
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Nationalities']")).click(); 
    }

    // ----- Scenario Outline Steps

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String btnName) {
        
        if(btnName.equalsIgnoreCase("Add"))
        {
            driver.findElement(By.xpath("//button[contains(., 'Add')]")).click();
        } 
        else if (btnName.equalsIgnoreCase("Save")) 
        {
            driver.findElement(By.xpath("//button[contains(., 'Save')]")).click();
        }
    }

    @When("the user enters {string} into the Name field")
    public void the_user_enters_into_the_name_field(String nationalityName) {
        // Passing the data from the <nationalityName> column in the Feature file
        WebElement nameField = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        nameField.sendKeys(nationalityName);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    @Then("the system should display a success message {string}")
    public void the_system_should_display_a_success_message(String expectedMessage) throws InterruptedException {
    	
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Locate the message 
    	WebElement TextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'oxd-text--toast-message')]")));
    	String actualMessage = TextElement.getText();
    	System.out.println("DEBUG: [" + actualMessage + "]");
        
        
        // Assert that the message contains the expected text
        Assert.assertTrue("print res: " + actualMessage, actualMessage.toLowerCase().contains("saved"));
    }

    @Then("the new nationality {string} should appear in the Nationalities list")
    public void the_new_nationality_should_appear_in_the_nationalities_list(String nationalityName) {
        // Verify the data exists in the table
       
        boolean isNationalityPresent = driver.findElements(By.xpath("//div[contains(text(), '" + nationalityName + "')]")).size() > 0;
        
        Assert.assertTrue("Nationality " + nationalityName + " was not found in the list.", isNationalityPresent);
        
        // Cleanup 
        
        driver.quit();
    }
}
