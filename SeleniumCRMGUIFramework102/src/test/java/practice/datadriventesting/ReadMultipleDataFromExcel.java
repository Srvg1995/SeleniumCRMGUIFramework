package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
    FileInputStream fis=new FileInputStream("C:\\Users\\gagan\\eclipse-workspace\\SeleniumCRMGUIFramework102\\src\\data\\testscriptdata5.xlsx");
    Workbook wb=WorkbookFactory.create(fis);
    Sheet sh = wb.getSheet("Sheet1");
    int rowCount = sh.getLastRowNum();
    for(int i=1;i<=rowCount;i++) {
    	Row row = sh.getRow(1);
    	String data1 = row.getCell(0).getStringCellValue();
    	String data2 = row.getCell(1).getStringCellValue();
    	System.out.println(data1+" "+data2); 	
    }
    wb.close();
	}

}
