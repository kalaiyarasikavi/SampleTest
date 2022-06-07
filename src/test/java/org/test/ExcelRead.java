package org.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
public class ExcelRead {
	public static void main(String[] args) throws IOException {
		
		//File
		
		File loc=new File("C:\\Users\\kalai\\eclipse-workspace\\MavenExcel\\src\\test\\resources\\Excel.xlsx");
		
		FileInputStream fi=new FileInputStream(loc);
		
		//workbook
		
		Workbook w=new XSSFWorkbook(fi);
		
		//sheet
		
		Sheet s = w.getSheet("Sheet1");
		
		//Row
		
		Row r = s.getRow(2);
		
		//cell
		
		Cell cell = r.getCell(0);
		System.out.println(cell);
		
//		WebElement e;
//		e.sendKeys(cell);
		
		//Row count
		int rowCount = s.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		
		//cell count
		int cellCount = r.getPhysicalNumberOfCells();
		System.out.println(cellCount);
		
		//get all values
		
		for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
			Row row = s.getRow(i);
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				Cell cell2 = row.getCell(j);
				System.out.println(cell2);
			}
		}
		
		
		
		
	}

}
