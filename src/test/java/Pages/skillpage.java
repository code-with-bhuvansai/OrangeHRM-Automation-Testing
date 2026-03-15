package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class skillpage {

	WebDriver driver;
	
	//constructor
    public skillpage(WebDriver driver)
    {
   	 this.driver=driver;
    }

	//navigation Locators

      By adminmainu = By.xpath("//li[1]//a[1]//span[1]");
     By qualification = By.xpath("//span[normalize-space()='Qualifications']");
     By skilloption = By.xpath("//a[normalize-space()='Skills']");
     
     //edit skill locators
     By editbtn =By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
     By inputtext =By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"); 
     
     By savebtn = By.xpath("//button[normalize-space()='Save']"); 

     
     
     
   //action for navigating skill page
       public void openskillpg() throws InterruptedException
       {
    	   Thread.sleep(5000);
    	   driver.findElement(adminmainu).click();
    	  
    	   driver.findElement(qualification).click();
    	   driver.findElement(skilloption).click();
    	  
    	  
       }
       
       public void editpage() throws InterruptedException
       {
    	   driver.findElement(editbtn).click();
    	   Thread.sleep(5000);
    	   driver.findElement(inputtext).clear();
    	   Thread.sleep(3000);
    	   driver.findElement(inputtext).sendKeys("Automation");
    	   
    	   driver.findElement(savebtn).click();
    	   driver.navigate().refresh();
    	   Thread.sleep(5000);
       }
      
       //verify edited skill
       public  boolean getEditedSkill()
       {
    	   String pageSource = driver.getPageSource();
           return pageSource.contains("Automation");
       }
       
       
       
  
       
}
