package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.PIMAddEmployee;

public class AddEmployeeTest extends BaseTest
{
	@Test
	 public void addEmployeeTest() {

	        

	        // Page Objects
	        LoginPage login = new LoginPage(driver);
	        PIMAddEmployee pim = new PIMAddEmployee(driver);

	        // Steps
	        login.login();
	        pim.navigateToAddEmployee();
	        pim.addEmployee("Rahul", "Sharma");

	        // Verification
	        Assert.assertTrue(pim.verifyEmployeeAdded(), "Employee not added");

	       
	    }
	

}
