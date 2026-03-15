package Task6;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Additionfunction {

	
	@Test
    @Parameters({"value1", "value2", "expectedSum"})
    public void testAddition(int num1, int num2, int expectedSum) {
        int actualSum = num1 + num2;
        
        System.out.println("Adding: " + num1 + " + " + num2);
        System.out.println("Result: " + actualSum);
        
        // Asserting 
        Assert.assertEquals(actualSum, expectedSum, "The addition result is incorrect!");
    }
	
	
	
	
}
