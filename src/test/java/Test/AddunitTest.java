package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.OrganizationStructurepage;

public class AddunitTest extends BaseTest {

    @Test
    public void addOrganizationUnitAndVerify() throws InterruptedException {

        

        LoginPage lp = new LoginPage(driver);
        lp.login();

        OrganizationStructurepage org = new OrganizationStructurepage(driver);
        org.openStructurePage();
        org.addUnit();

        boolean result = org.verifyUnitAdded();
 
System.out.println("Unit added:"+result);
        Assert.assertTrue(result, "Unit not added");
    }
}

