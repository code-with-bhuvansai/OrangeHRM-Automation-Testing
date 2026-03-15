package BDD;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepAddmembership {

    
    static WebDriver driver;
    static WebDriverWait wait;

    // GIVEN
    @Given("the admin user is logged into the OrangeHRM application")
    public void login() {

        // browser 
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // WHEN
    @When("the user opens the membership configuration page")
    public void open_membership_page() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']"))).click();

        driver.findElement(By.xpath("//span[text()='Qualifications']")).click();

        driver.findElement(By.xpath("//a[text()='Memberships']")).click();
    }

    @When("the user enters membership name as {string}")
    public void enter_membership_name(String membership) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add ']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='oxd-input oxd-input--active']"))).sendKeys(membership);
    }

    @When("saves the membership details")
    public void save_membership() {

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    //  THEN 
    @Then("the membership {string} should be visible in the membership list")
    public void verify_membership(String membership) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='table']")));

        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='row']"));

        for (WebElement row : rows) {
            if (row.getText().contains(membership)) {
                System.out.println("MEMBERSHIP FOUND : " + membership);
                break;
            }
        }

        //browser close at end
        driver.quit();
        driver = null;
    }
}
