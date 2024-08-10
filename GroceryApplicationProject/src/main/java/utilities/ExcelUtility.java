package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;

	public static String getString(int i, int j, String sheet) 
	{
		String file_path = GeneralUtilities.TESTDATAFILE;
		try 
		{
			f = new FileInputStream(file_path);
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try 
		{
			wb = new XSSFWorkbook(f);	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
		
	}
}
