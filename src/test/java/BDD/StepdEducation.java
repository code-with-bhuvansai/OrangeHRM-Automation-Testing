package BDD;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class StepdEducation {

    WebDriver driver;
    WebDriverWait wait;

    // Given
    @Given("the user will login into OrgHRM")
    public void login_into_orangehrm() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));

        System.out.println("LOGIN SUCCESS");
    }

    //WHEN
    @When("user will edits education {string} to {string}")
    public void edit_education(String oldEducation, String newEducation) throws InterruptedException {

        driver.findElement(By.xpath("//span[text()='Admin']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Qualifications']"))).click();

        driver.findElement(By.xpath("//a[normalize-space()='Education']")).click();
        
        Thread.sleep(5000);

        List<WebElement> rows = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-table-body']//div[@role='row']")));

        for (WebElement row : rows) {

            String text = row.findElement(
                    By.xpath("//div[@class='orangehrm-container']")).getText();

            System.out.println("ROW FOUND :" + text);

            if (text.equalsIgnoreCase(oldEducation)) {

                System.out.println("MATCH FOUND :" + text);

                // Click Edit button
                row.findElement(By.xpath(".//button[@title='Edit']")).click();

                WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='oxd-input oxd-input--active']")));

                input.clear();
                input.sendKeys(newEducation);

                driver.findElement(By.xpath("//button[@type='submit']")).click();

                System.out.println("UPDATED TO : " + newEducation);
                break;
            }
        

        }
    }

     // THEN 
    @Then("education should updated successfully")
    public void verify_education_updated() throws InterruptedException {

        Thread.sleep(3000); 

        WebElement res = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast')]"));

        System.out.println("RESULT = " + res.getText());
    }


}
