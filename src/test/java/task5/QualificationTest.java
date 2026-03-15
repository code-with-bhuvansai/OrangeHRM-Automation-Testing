package task5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QualificationTest {


		@Test
	    public void openSkillsPage() {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	        // Login
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin");

	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	        // Navigate to Skills
	        driver.findElement(By.xpath("//a[normalize-space()='']")).click();
	        driver.findElement(By.xpath("//span[normalize-space()='Qualifications']")).click();
	        driver.findElement(By.xpath("//a[normalize-space()='Skills']")).click();

	        // Verification
	        Assert.assertTrue(driver.getCurrentUrl().contains("viewSkills"),"Skills page not opened");

	        driver.quit();
	    }
		
		
		@Test
	    public void openEducationPage() {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	     // Login
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin");

	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	        // Navigate to Education
	        driver.findElement(By.xpath("//a[normalize-space()='']")).click();
	        driver.findElement(By.xpath("//span[normalize-space()='Qualifications']")).click();
	        driver.findElement(By.xpath("(//a[normalize-space()='Education'])[1]")).click();

	        // Verification
	        Assert.assertTrue(driver.getCurrentUrl().contains("viewEducation"),"Education page not opened");

	        driver.quit();
	    }
		

	}


