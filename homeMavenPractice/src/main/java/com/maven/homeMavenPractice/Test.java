package com.maven.homeMavenPractice;

import com.maven.excelPractice.ExcelAPI;

public class Test
{

	public static void main(String[] args) throws Exception 
	{
		
		ExcelAPI e = new ExcelAPI("C:\\Users\\shahe\\OneDrive\\Desktop\\Screenshots\\testdata.xlsx");
		
		System.out.println(e.getCellDataByColumnNo("login", 3, 3));
		System.out.println(e.getCellDataByColumnName("login", 3, "DateCreated"));
		
	}
	
	

}
