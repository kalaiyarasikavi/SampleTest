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

public class ExcelWrite {
	
	public static void main(String[] args) throws IOException {
		
		//New Excel sheet
		File loc=new File("C:\\Users\\kalai\\eclipse-workspace\\MavenExcel\\src\\test\\resources\\Data.xlsx");
//		Workbook w=new XSSFWorkbook();
//		Sheet s = w.createSheet("Sheet1");
//		Row r = s.createRow(3);
//		Cell cell = r.createCell(3);
//		cell.setCellValue("kavi");
//		System.out.println(cell);
//		
//		FileOutputStream fi=new FileOutputStream(loc);
//		w.write(fi);
		
		//Existing sheet
		FileInputStream f=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(f);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(3);
		Cell cell = r.createCell(2);
		cell.setCellValue("suganya");
		System.out.println(cell);
		
		FileOutputStream fi=new FileOutputStream(loc);
		w.write(fi);
		System.out.println("Done");
	}

}
