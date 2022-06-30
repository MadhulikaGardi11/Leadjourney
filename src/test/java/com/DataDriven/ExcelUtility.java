package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String getPUData(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("D:\\UserDetails.xlsx");
		Sheet sh= WorkbookFactory.create(file).getSheet("Users");
		String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		
		return value;

	}

	public static String getAssignedUserData(int rowIndex, int cellIndex ) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("D:\\UserDetails.xlsx");
		Sheet sh= WorkbookFactory.create(file).getSheet("Assigned User Details");
		String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		
		return value;
	}
}
