package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver launchBrowser(String browsername) {
		switch (browsername) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Invalid browser name");
			break;
		}

		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static String getCurrentURL() {
		String url = driver.getCurrentUrl();
		return url;

	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}
	
	public static void sendkeys(WebElement e,String value) {
e.sendKeys(value);
	}

	public static void quitBrowser() {
		driver.quit();

	}

	public static void fillTextBox(WebElement e, String value) {
		e.sendKeys(value);

	}

	public static void btnClick(WebElement e) {
		e.click();
	}

	public static String getAttribute(WebElement e) {
		return e.getAttribute("value");
	}

	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();

	}

	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();

	}

	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);

	}

	public static WebElement findElement(String locatoname, String locator) {
		WebElement e=null;
		if (locatoname.equals("id")) {
			 e = driver.findElement(By.id(locator));
			
		}
		else if (locatoname.equals("name")) {
			 e = driver.findElement(By.name(locator));
			
		}
		else if (locatoname.equals("xpath")) {
			 e = driver.findElement(By.xpath(locator));
			
		}
		return e;
	}
	
	public static String getExcelData(String FileName,String sheetName,int row,int cells) throws IOException {
		File loc=new File("C:\\Users\\kalai\\eclipse-workspace\\MavenExcel\\src\\test\\resources\\"+FileName+".xlsx");
		FileInputStream fi=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(row);
		Cell cell = r.getCell(cells);
		int type = cell.getCellType();
		
		String value=null;
		
		if(type==1) {
			 value = cell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				 value = new SimpleDateFormat("dd-MMM-yyyy").format(cell.getDateCellValue());
			}
			else {
				 value = String.valueOf((long)cell.getNumericCellValue());
			}
		}
		return value;

	}	
		
	
	

	

}
