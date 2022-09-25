package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelFileUtil {
XSSFWorkbook wb;
//constructor for Reading excel path
public ExcelFileUtil(String Excelpath)throws Throwable{
FileInputStream fi = new FileInputStream(Excelpath);
	wb =  new XSSFWorkbook(fi);
	}
// count no of rows in a sheet
public int rowCount(String SheetName) {
	return wb.getSheet(SheetName).getLastRowNum();
	}
// count no of cells in row
public int cellCount(String SheetName) {
	return wb.getSheet(SheetName).getRow(0).getLastCellNum();
	}
// get cell data
public String getcellData(String SheetName,int row, int column) {
	String data = "";
	if (wb.getSheet(SheetName).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC) 
	{
int Celldata=(int)wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
data=String.valueOf(Celldata);
	}		
	else
	{
		data = wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	return data;
}
// write set cell data
public void setCelldata(String SheetName,int row, int column,String Status,String writeExcelpath) throws Throwable {
	//get sheet from wb
	XSSFSheet ws = wb.getSheet(SheetName);
	// get row from sheet
	XSSFRow rowNum =ws.getRow(row);
	//create cell
	XSSFCell cell = rowNum.createCell(column);
	// write status
	if (Status.equalsIgnoreCase("pass")) {
	XSSFCellStyle Sytle = wb.createCellStyle();
	XSSFFont font = wb.createFont();
	font.setColor(IndexedColors.GREEN.getIndex());
	font.setBold(true);
	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	Sytle.setFont(font);
	rowNum.getCell(column).setCellStyle(Sytle);
	}
	else if (Status.equalsIgnoreCase("pass")) {
	XSSFCellStyle style = wb.createCellStyle();
	XSSFFont font=wb.createFont();
	font.setColor(IndexedColors.RED.getIndex());
	font.setBold(true);
	rowNum.getCell(column).setCellStyle(style);
	}
	else if (Status.equalsIgnoreCase("Blocked")) {
	XSSFCellStyle style =wb.createCellStyle();
	XSSFFont font = wb.createFont();
	font.setColor(IndexedColors.BLUE.getIndex());
	font.setBold(true);
	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	style.setFont(font);
	rowNum.getCell(column).setCellStyle(style);
	}
FileOutputStream fo = new FileOutputStream(writeExcelpath);
wb.write(fo);
}
public static void main(String[] args) throws Throwable {
ExcelFileUtil xl = new ExcelFileUtil("D://MBook.xlsx");	
// count no of rows
int rc = xl.rowCount("Admin");
int cc = xl.cellCount("Admin");
System.out.println(rc+"    "+cc);
for(int i=1;i<=rc;i++) {
	String user = xl.getcellData("Admin", i, 0);
	String pass = xl.getcellData("Admin", i, 1);
	System.out.println(user+"   "+pass);
	xl.setCelldata("Admin", i, 2, "pass","D:/Results.xlsx");
}
}
}
