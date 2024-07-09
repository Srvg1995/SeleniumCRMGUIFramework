package practice.testNG;

import org.testng.annotations.Test;

public class ContactTest {
	
	@Test                                             //Priority can start from (-1/0) also
	public void createContactTest()                   //But,its better to avoid giving priority in real time
	{
		System.out.println("execute createContactTest with-->HDFC");
	}

	@Test
	public void modifyContactTest()
	{
		System.out.println("execute query insert contact into DB==ICICI");
		System.out.println("execute modifyContactTest-->ICICI=>ICICI_1");


	}
	
	@Test
	public void deleteContactTest()
	{
		System.out.println("execute query insert contact into DB==>UPI");
		System.out.println("execute deleteContactTest UPI");

	}
}

