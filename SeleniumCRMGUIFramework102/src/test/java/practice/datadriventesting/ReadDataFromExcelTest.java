package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {

	FileInputStream fis=new FileInputStream("C:\\Users\\gagan\\eclipse-workspace\\SeleniumCRMGUIFramework102\\testscriptdata1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	System.out.println(data);
	wb.close();
	}

}
