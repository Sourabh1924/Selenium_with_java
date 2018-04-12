package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Get_data {

	static Workbook WB;
	static String Excel_path="F:\\Clear.xls";
	static int rownum = 5;
	static int colnum = 0;
	static String data = "Samrat";
	static String Sheetname = "Sheet1";
	
	
	//Read data from excel file
	public static String Read(String Sheetname,int rownum,int colnum) throws Throwable
	{
		FileInputStream fin=new FileInputStream(Excel_path);    
		WB=WorkbookFactory.create(fin);
		
		Sheet sh = WB.getSheet(Sheetname);
		Row rw = sh.getRow(rownum);
		Cell cell = rw.getCell(colnum);
		String data = cell.toString();
		System.out.println(data);
		return data;   
	}	
	
	//Write data from excel file
	public static String Write(String Sheetname,int rownum,int colnum,String data) throws Throwable
	{
		FileInputStream fin=new FileInputStream(Excel_path);    
		WB=WorkbookFactory.create(fin);
		CellStyle my_style = WB.createCellStyle();
		my_style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		Sheet sh = WB.getSheet(Sheetname);
		Row rw = sh.getRow(rownum);	
		Cell cell = rw.getCell(colnum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		
		FileOutputStream fout = new FileOutputStream(Excel_path);
		WB.write(fout);
		WB.close();
		return null;
	}

	//Excel reporter
	public static void Excel_Reporter(String Step,String Step_details,String Actual,String Status,String Time) throws Throwable
	{ 
		String Attribute[] =  {"Step_name","Step_details","Actual","Status","Time"};
		try{
			FileInputStream fin=new FileInputStream(Excel_path); 
			WB=WorkbookFactory.create(fin);
		}
		catch(Exception e){
			System.out.println(e);
		}
		Sheet sh = WB.getSheet(Sheetname);
		int Row_cnt = sh.getLastRowNum();
		Row newRow = sh.createRow(0);
		  	for(int j=0;j<=4;j++)
		  	{		  	
				newRow.createCell(j).setCellValue(Attribute[j]);
		  	}
		  
		String Attribute_value[] =  {Step,Step_details,Actual,Status,Time};
		Row newRow1 = sh.createRow(Row_cnt+1);
			for(int i=0;i<=4;i++)
				{
				newRow1.createCell(i).setCellValue(Attribute_value[i]);
				}	
		FileOutputStream fout = new FileOutputStream(Excel_path);
		WB.write(fout);
		WB.close();
	}

	//Create excel file
	public static void Create() throws Throwable
	{
		Workbook Wb = null;
			if (Excel_path.endsWith(".xls"))
			{
				Wb = new HSSFWorkbook();
			}
			else
			{
				Wb = new XSSFWorkbook();
			}
		Wb.createSheet("Sheet1").createRow(0).createCell(0);
		FileOutputStream fout = new FileOutputStream(Excel_path);
		Wb.write(fout);
		Wb.close();
	}
	
	
	public static void Color() throws Throwable
	{
		
		WB = new XSSFWorkbook();
	    Sheet sheet = WB.createSheet("Color Test");
	    Row row = sheet.createRow(0);

	    CellStyle style = WB.createCellStyle();
	    style.setFillBackgroundColor(IndexedColors.GREEN.index);
	    org.apache.poi.ss.usermodel.Font font = WB.createFont();
        font.setColor(IndexedColors.RED.getIndex());
        style.setFont(font);
        
	    Cell cell1 = row.createCell(0);
	    cell1.setCellValue("ID");
	    cell1.setCellStyle(style);
	    
	    Cell cell2 = row.createCell(1);
	    cell2.setCellValue("NAME");
	    cell2.setCellStyle(style);

	    FileOutputStream fos =new FileOutputStream(new File("F:\\Clear.xlsx"));
	    WB.write(fos);
	    fos.close();
	    System.out.println("Done");
	
	}
	
	public static void main(String[] args) throws Throwable {
		
		//Get_data.Read(Sheetname, rownum, colnum);
		
		//Get_data.Write(Sheetname, rownum, colnum,data);
		
		//Get_data.Create();
		
//		Date dateobj = new Date();
//		Get_data.Excel_Reporter("Step 1","Enter value","Value is put","PASS",dateobj.toString());
		
		Get_data.Color();
	}
	
}
	
