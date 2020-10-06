package com.maven.excelPractice;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConnect {
	
	public static  FileInputStream fis;
	public static void main(String[] args) throws Exception 
	{
	
		
			 fis = new FileInputStream("C:\\Users\\shahe\\OneDrive\\Desktop\\Screenshots\\testdata.xlsx");
			 XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("login");
			XSSFRow row = sheet.getRow(0);
			int cellNum = 0;
			
			for(int i=0; i<=row.getLastCellNum(); i++)
			{
				
				System.out.println(row.getCell(i));
				
			}
		
			wb.close();
			fis.close();
	}

}
