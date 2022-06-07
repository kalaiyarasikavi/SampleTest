package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdate {
	
	public static void main(String[] args) throws IOException {
		
		File loc=new File("C:\\Users\\kalai\\eclipse-workspace\\MavenExcel\\src\\test\\resources\\Data.xlsx");

		
		FileInputStream f=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(f);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(3);
		Cell cell = r.getCell(3);
		String value = cell.getStringCellValue();
		if(value.equals("kavi")) {
			cell.setCellValue("kalai");
		}
		
		FileOutputStream fi=new FileOutputStream(loc);
		w.write(fi);
		System.out.println("Done");
	}

}
