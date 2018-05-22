package com.skypeForBusiness.Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelDataMethod {
	public static String path="C:\\Users\\TYSS\\git\\AppiumGitLocalRepos\\appiumDemoPro\\src\\test\\resources\\byjus.xlsx";
	
	public static String getExcelData(String SheetName,int RowNumber,int CellNumber) throws Throwable{
		
		
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row row=sh.getRow(RowNumber);
		String Data=row.getCell(CellNumber).getStringCellValue();
		wb.close();
		return Data;
	
		
	}
	
	
	public void setExcelData(String SheetName,String data,int RowNumber,int CellNumber) throws Throwable{
	
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row row=sh.getRow(RowNumber);
		row.createCell(CellNumber).setCellValue(data);
//		Cell cel=row.createCell(CellNumber);
//				cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		wb.close();
			
}

}
