package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrganizationStructurepage {

    WebDriver driver;
    WebDriverWait wait;
    
    

    public OrganizationStructurepage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By adminMenu = By.xpath("//span[text()='Admin']");
    By organization = By.xpath("//span[normalize-space()='Organization']");
    By structure = By.xpath("//a[normalize-space()='Structure']");

    By editToggle = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-left']");
    By addBtn = By.xpath("//button[normalize-space()='Add']");
    By unitInput = By.xpath("//div[@role='dialog']//div[2]//div[1]//div[2]//input[1]");
    By saveBtn = By.xpath("//button[normalize-space()='Save']");

    // Navigation
    public void openStructurePage() {

        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization)).click();
        wait.until(ExpectedConditions.elementToBeClickable(structure)).click();
    }

    // Add unit
    public void addUnit() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(editToggle)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(unitInput)).sendKeys("Automation");
        
        driver.findElement(saveBtn).click();
        
        
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    // VERIFY UNIT
    public boolean verifyUnitAdded()  
    {
    
        String pageSource = driver.getPageSource();
        return pageSource.contains("Automation");
      
        
    }
}
