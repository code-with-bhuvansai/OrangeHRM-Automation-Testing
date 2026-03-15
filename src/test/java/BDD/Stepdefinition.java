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

public class Stepdefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("user is logged in to OrangeHRM")
    public void user_is_logged_in_to_orangehrm() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));

        System.out.println("LOGIN SUCCESSFUL");
    }

    @When("user deletes job title {string}")
    public void user_deletes_job_title(String jobTitle) {

        System.out.println("JOB TITLE TO DELETE = " + jobTitle);

        // Admin -Job Job- Titles
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Job']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Job Titles"))).click();

        // wait for table
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-body']")));

        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));

        System.out.println("TOTAL ROWS FOUND = " + rows.size());

        boolean found = false;

        for (WebElement row : rows) {


            System.out.println("ROW DATA = " + row.getText());

            if (row.getText().contains(jobTitle)) 
            {
                System.out.println("MATCH FOUND = " + jobTitle);

                WebElement checkbox = row.findElement(By.xpath(".//div[contains(@class,'oxd-checkbox-wrapper')]"));
                checkbox.click();

                System.out.println("CHECKBOX CLICKED");
                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("JOB TITLE NOT FOUND");
            return;
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Delete Selected']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes, Delete']"))).click();

        System.out.println("DELETE CLICKED");
    }

    @Then("job title should be deleted successfully")
    public void job_title_should_be_deleted_successfully() {

        WebElement res = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-toast-content')]")));

        System.out.println("SUCCESS = " + res.getText());

        driver.quit();
    }

}
