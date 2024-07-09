package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest {

	public static void main(String[] args) throws Throwable {
		String expectedTestId="tc_02";
		String data1 = "";  //in order to use these 'data1/2/3' in line#32,33,34 ,we declared here.
		String data2 = "";
		String data3 = "";
		boolean flag = false;


		FileInputStream fis=new FileInputStream("C:\\Users\\gagan\\eclipse-workspace\\SeleniumCRMGUIFramework102\\src\\data\\testscriptdata2.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		int rowCount = sh.getLastRowNum();
		for(int i=0;i<=rowCount;i++) {
			String data = "";	 //here in order to print the 'data1/2/3' variable outside the try-catch block,we declare it like global variable.
//here we use try&catch block since,in my excel sheet some empty row is there after every testcase(To avoid NULL POINTER EXCEPTION)
			try {      
				data = sh.getRow(i).getCell(0).toString();
				if(data.equals(expectedTestId)) {
					flag=true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();
				}
			}
			catch (Exception e) {
			}
		}

		if(flag==true) //here we are declared&using 'flag variable' in order to give msg to the user if the data which is searching by the user is not availabel,then it should display "data is not available" to the user. 
		{
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}
		else 
		{
			System.out.println(expectedTestId+" data is not available");    
		}
		wb.close();
	}
}


