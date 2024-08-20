package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
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
	
	 public static int getInt(int i, int j, String sheet) {
	        String filePath = GeneralUtilities.TESTDATAFILE;
	        int cellValue = 0;

	        try {
	            f = new FileInputStream(filePath);
	            wb = new XSSFWorkbook(f);
	            sh = wb.getSheet(sheet);
	            
	            Row row = sh.getRow(i);
	            if (row != null) {
	                Cell cell = row.getCell(j);
	                if (cell != null) {
	                    // Check if the cell contains a numeric value
	                    if (cell.getCellType() == CellType.NUMERIC) {
	                        cellValue = (int) cell.getNumericCellValue();
	                    } else if (cell.getCellType() == CellType.STRING) {
	                        // If the cell contains a string, attempt to parse it as an integer
	                        cellValue = Integer.parseInt(cell.getStringCellValue());
	                    }
	                }
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace(); // Handle File Not Found
	        } catch (IOException e) {
	            e.printStackTrace(); // Handle IO Exception
	        } catch (NumberFormatException e) {
	            e.printStackTrace(); // Handle the case where the cell string cannot be parsed as an integer
	        } finally {
	            try {
	                if (wb != null) {
	                    wb.close();
	                }
	                if (f != null) {
	                    f.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace(); // Handle Exception during close
	            }
	        }
	        return cellValue;
	    }
}
