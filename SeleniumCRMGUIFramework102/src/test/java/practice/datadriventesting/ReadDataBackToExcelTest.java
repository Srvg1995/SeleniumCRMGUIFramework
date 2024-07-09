package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcelTest {

	public static void main(String[] args) throws Throwable, IOException {

	FileInputStream fis=new FileInputStream("C:\\Users\\gagan\\eclipse-workspace\\SeleniumCRMGUIFramework102\\src\\data\\testscriptdata2.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet("org").getRow(1).getCell(4).setCellValue("PASS");
	
	
	FileOutputStream fos=new FileOutputStream("C:\\Users\\gagan\\eclipse-workspace\\SeleniumCRMGUIFramework102\\src\\data\\testscriptdata2.xlsx");
	wb.write(fos);
	wb.close();
	System.out.println("==============Executed============");
	}

}
