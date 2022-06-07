package org.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
public class ExcelReadType {
	public static void main(String[] args) throws IOException {
		File loc=new File("C:\\Users\\kalai\\eclipse-workspace\\MavenExcel\\src\\test\\resources\\Excel.xlsx");
		FileInputStream fi=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(2);
		Cell cell = r.getCell(2);
		System.out.println(cell);
		//Type 1---->String(name)
		//Type 0----> Numbers,Date
		int type = cell.getCellType();
		System.out.println(type);
		if(type==1) {
			String value = cell.getStringCellValue();
			System.out.println(value);
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date d = cell.getDateCellValue();
				SimpleDateFormat si=new SimpleDateFormat("dd-MMM-yyyy");
				String value = si.format(d);
				System.out.println(value);
			}
			else {
				double db = cell.getNumericCellValue();
				long l=(long)db;
				String value = String.valueOf(l);
				System.out.println(value);
			}
		}
	}
}
