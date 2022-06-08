package org.test;

import java.io.IOException;

import org.base.BaseClass;
import org.pages.LoginPage;

public class BrowserLaunch extends BaseClass{
	public static void main(String[] args) throws IOException {
		
		launchBrowser("Chrome");
		launchUrl("https://www.facebook.com/");
		
		LoginPage l=new LoginPage();
		
		sendkeys(l.getTxtUserName().get(0),getExcelData("Excel", "Sheet1", 1, 0));
		sendkeys(l.getTxtPassword(), getExcelData("Excel", "Sheet1", 1, 1));
		
		btnClick(l.getBtnClick());
		
		System.out.println("Hiiiiii");
	}

}
