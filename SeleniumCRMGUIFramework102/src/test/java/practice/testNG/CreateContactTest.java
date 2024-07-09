package practice.testNG;

import org.testng.annotations.Test;

public class CreateContactTest {   //This is wrong because for 1Testcase,here using 3 @Test annotation which not happen,because 1 Testcase should contain only 1 @Test annotations. 
	@Test                             
	public void login()    
	{
		System.out.println("loginTest");
	}

	@Test
	public void navigateTocontactTest()
	{
		System.out.println("navigateTocontactTest");
		
	}
	
	@Test
	public void createcontactTest()
	{
		System.out.println("createcontactTest");

	}
}
