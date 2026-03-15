package Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class countrydropdown {
    public static void main(String[] args) {

        // 1. Chrome Browser
        WebDriver driver = new ChromeDriver();
        
        // 2. Website 
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        // 3. Dropdown
        WebElement drpCountry = driver.findElement(By.name("country"));

        // 4. Select class use
        Select countrySelect = new Select(drpCountry);
        countrySelect.selectByVisibleText("INDIA");

        System.out.println("Success! India selected");

        driver.quit();
    }
}