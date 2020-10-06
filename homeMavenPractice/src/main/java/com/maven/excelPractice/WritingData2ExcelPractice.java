package com.maven.excelPractice;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingData2ExcelPractice {

	public static void main(String[] args) throws Exception {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("EmployeeInfo");
		XSSFRow row;
		
		TreeMap<String, Object[]> empInfo = new TreeMap<String, Object[]>();
		empInfo.put("1", new Object[]   {"EMP_NAME", "EMP_CITY", "EMP_TELL"});
		empInfo.put("2", new Object[] {"Shaan", "Sylhet", 171985});
		empInfo.put("3", new Object[] {"Nazrul", "Toronto", 4166872});
		empInfo.put("4", new Object[] {"Ayman", "NewYork", 9293511});
		empInfo.put("5", new Object[] {"Islam", "Bronx", 3421234});
		
		Set<String> keyid = empInfo.keySet();
		int rowid =0;
		for(String key : keyid)
		{
			row = sheet.createRow(rowid++);
			Object[] objArr = empInfo.get(key);
			int cellid = 0;
			
			for(Object obj : objArr)
			{
				XSSFCell cell = row.createCell(cellid++);
			
				//cell.setCellValue((String)obj);
				  if(obj instanceof String)
		            {
		            	cell.setCellValue((String)obj);
		            }
		            else if(obj instanceof Integer)
		            {
		            	cell.setCellValue((int) obj);
		            }
				
			}
		}
		
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\shahe\\work\\Bismillah1.xlsx"));
		wb.write(fos);
		fos.close();
		System.out.println("writing to excel successfully completed.");
	}
	
}