package Test;


import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.skillpage;

public class EditTest extends BaseTest
{
  
  
	@Test
	public void editSkillandVerify() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		skillpage sp = new skillpage(driver);
		sp.openskillpg();
		sp.editpage();
		
		
		boolean result = sp.getEditedSkill();
		System.out.println("updates:"+result);
		
		 Assert.assertEquals(result, "Automation");
		
		
	}
	
	
}
