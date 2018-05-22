package com.skypeForBusiness.Generic;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils
{
	static String path1 =System.getProperty("user.dir");
	static String path=path1+"\\data\\Book1.xlsx";
public static String getExcelData(String SheetName,int RowNumber,int CellNumber) throws Throwable{
		
		
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row row=sh.getRow(RowNumber);
		String Data=row.getCell(CellNumber).getStringCellValue();
		wb.close();
		return Data;
	
		
	}
public static void setExcelData(String SheetName,String data,int RowNumber,int CellNumber) throws Throwable{
	
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(SheetName);
	Row row=sh.getRow(RowNumber);
	row.createCell(CellNumber).setCellValue(data);
	FileOutputStream fos=new FileOutputStream(path);
	wb.write(fos);
	wb.close();
		
}

public static int getRowNo(String SheetName) throws Throwable{
	
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(SheetName);
	int row=sh.getLastRowNum();
	return row;
		
}

	
}
