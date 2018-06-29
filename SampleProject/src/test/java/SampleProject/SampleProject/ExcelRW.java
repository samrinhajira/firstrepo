package SampleProject.SampleProject;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	XSSFWorkbook wb;
	FileInputStream fis;
	public ExcelRW(String filePath) throws Exception{
		fis=new FileInputStream(filePath);
		wb=new XSSFWorkbook(fis);
	}
	public int getRow(String sheetName){
			XSSFSheet sheet = wb.getSheet(sheetName);
			return sheet.getLastRowNum();
	}
	public int getCloumn(String sheetName){
		XSSFSheet sheet=wb.getSheet(sheetName);
		return sheet.getRow(0).getLastCellNum();		
	}
	public String readCell(String sheetName,int row,int col){
		XSSFSheet sheet = wb.getSheet(sheetName);
		XSSFCell cell=sheet.getRow(row).getCell(col);
		String celltext="";
		if(cell.getCellType()==cell.CELL_TYPE_STRING){
			 celltext = cell.getStringCellValue();
		}
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
			celltext = String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==cell.CELL_TYPE_BLANK){
			celltext="";
		}
		
		return celltext;		
	}
	public void writeCell(String sheetName,int row,int col,String value){
		XSSFSheet sheet =wb.getSheet(sheetName);
		sheet.getRow(row).getCell(col).setCellValue(value);
	}
}
