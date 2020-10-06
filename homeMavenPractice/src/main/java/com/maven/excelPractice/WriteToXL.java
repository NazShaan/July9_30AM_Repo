package com.maven.excelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToXL {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\shahe\\OneDrive\\Desktop\\Screenshots\\testdata.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(4);
		XSSFCell cell = row.getCell(4);
		cell.setCellValue("Nazrul Ayman");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\shahe\\OneDrive\\Desktop\\Screenshots\\testdata.xlsx");
		wb.write(fos);
		
		fos.close();
		fis.close();
		wb.close();
	}

}
