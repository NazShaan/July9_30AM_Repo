package com.maven.excelPractice;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.maven.homeMavenPractice.TestBasics;

public class ExcelAPI extends TestBasics
{
	public  FileInputStream fis=null;
	public  String filePath=null;
	public   XSSFWorkbook wb=null;
	public  XSSFSheet sheet=null;
	public  XSSFRow row=null;
	public XSSFCell cell=null;
	public  ExcelAPI(String filePath) throws Exception
	{
		System.out.println("Excel is initilizing................");
		this.filePath = filePath;
		fis=new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		
	}
	
	public  String getCellDataByColumnNo(String sheetName, int rowNum, int ColNo)
	{
		sheet =wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(ColNo);
		String str=null;
		if(cell.getCellTypeEnum().equals(CellType.STRING))
		{
			str =cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum().equals(CellType.NUMERIC) ||  cell.getCellTypeEnum()==CellType.FORMULA)
		{
			str =String.valueOf(cell.getNumericCellValue());
			if(HSSFDateUtil.isCellDateFormatted(cell))
			{
				DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
				java.util.Date date = cell.getDateCellValue();
				str=dt.format(date);	
			}
			else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			{
				str =String.valueOf(cell.getBooleanCellValue());
			}
			else if (cell.getCellTypeEnum()==CellType.BLANK)
			{
				str =" ";
			}
		}
		
		return str;
	}
	
	public String getCellDataByColumnName(String sheetName, int rowNum, String colName)
	{
		String str=null;
		int colNum=-1;
		sheet =wb.getSheet(sheetName);
		row =sheet.getRow(0);
		
		for(int i=0; i<row.getLastCellNum(); i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
			{
				colNum=i;
			}
		}
		
		 cell = row.getCell(colNum);
		
		if(cell.getCellTypeEnum().equals(CellType.STRING))
		{
			str =cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum().equals(CellType.NUMERIC) ||  cell.getCellTypeEnum()==CellType.FORMULA)
		{
			str =String.valueOf(cell.getNumericCellValue());
			if(HSSFDateUtil.isCellDateFormatted(cell))
			{
				DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
				java.util.Date date = cell.getDateCellValue();
				str=dt.format(date);	
			}
			else if(cell.getCellTypeEnum()==CellType.BOOLEAN)
			{
				str =String.valueOf(cell.getBooleanCellValue());
			}
			else if (cell.getCellTypeEnum()==CellType.BLANK)
			{
				str =" ";
			}
		}
		
		return str;
		
	}
	
	
}
