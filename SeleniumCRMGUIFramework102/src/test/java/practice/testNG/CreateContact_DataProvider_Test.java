package practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider_Test {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName,long phoneNumber)
	{
		System.out.println("FirstName:"+ firstName +",LastName:"+lastName+",phoneNumber:"+phoneNumber);
	}
	
	@DataProvider
	public Object [][] getData()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="deepak";
		objArr[0][1]="HR";
		objArr[0][2]=9886668812l;
		
		objArr[1][0]="sam";
		objArr[1][1]="SH";
		objArr[1][2]=9875946465l;
		
		objArr[2][0]="Jhon";
		objArr[2][1]="smith";
		objArr[2][2]=9898989887l;
		
		return objArr;
		
	
	}
	

}
