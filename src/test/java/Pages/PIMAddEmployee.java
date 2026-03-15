package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMAddEmployee
{
    WebDriver driver;
    WebDriverWait wait;
    
    public PIMAddEmployee(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // PIM Locators
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployeeMenu = By.xpath("//a[text()='Add Employee']");

    // Add Employee Page Locators
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");
    By personalDetails = By.xpath("//h6[text()='Personal Details']");

    // Actions
    public void navigateToAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeMenu)).click();
    }

    public void addEmployee(String fname, String lname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(saveBtn).click();
    }

    public boolean verifyEmployeeAdded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetails)).isDisplayed();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
