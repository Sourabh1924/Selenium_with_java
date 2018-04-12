package com.RA.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_libraries {
	
	public static String Folder_path = Utility_libraries.Folder_path;
	static String Excel_path =  Utility_libraries.Excel_path;
	static Workbook WB;
	
	//-------------------------------------------Excel reporter---------------------------------------------
	 public static void Excel_Reporter(String Step_details,String Actual,String Status,String Time) throws Throwable
			{ 
				String Attribute[] = {"Step_details","Actual","Status","Time"};
					try{
						FileInputStream fin=new FileInputStream(Excel_path); 
						WB=WorkbookFactory.create(fin);
						}
					catch(Exception e){
						System.out.println(e);
						}
				Sheet sh = WB.getSheet("Sheet1");
				int Row_cnt = sh.getLastRowNum();
				Row newRow = sh.createRow(0);
				  	for(int j=0;j<=3;j++)
				  	{		  	
						newRow.createCell(j).setCellValue(Attribute[j]);
				  	}
				  
				String Attribute_value[] =  {Step_details,Actual,Status,Time};
				Row newRow1 = sh.createRow(Row_cnt+1);
					for(int i=0;i<=3;i++)
						{
						newRow1.createCell(i).setCellValue(Attribute_value[i]);
						}	
				FileOutputStream fout = new FileOutputStream(Excel_path);
				WB.write(fout);
				WB.close();
			}
		    
	//------------------------------------------Create Excel file------------------------------------------
	 public static String Create_Excel_file() throws Throwable
			{
				Workbook Wb = null;
				if ((new File(Excel_path)).exists()==false) {	
			      		
					if (Excel_path.endsWith(".xls"))  {  
							Wb = new HSSFWorkbook();
						}
						else  {
							Wb = new XSSFWorkbook();
						}
					Wb.createSheet("Sheet1").createRow(0).createCell(0);
					FileOutputStream fout = new FileOutputStream(Excel_path);
					Wb.write(fout);
					Wb.close();
				}
				return Excel_path;
			}

	 //------------------------------------------For data access--------------------------------------------
	 public static String Read(String Attri_name,String File_name,String Sheet_name) throws Throwable
	     {
			FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"\\RA_Data\\"+File_name);

			WB=WorkbookFactory.create(fin);
			Sheet sh = WB.getSheet(Sheet_name);
			int Row_cnt = sh.getLastRowNum();	
			   for(int i=0;i<=Row_cnt;i++)  
			   {
				   Row rw_obj = sh.getRow(i);
				   Cell cell_obj = rw_obj.getCell(0);
				   String Attri = cell_obj.toString();
				      if(Attri.equals(Attri_name)) 
				      {
						   Cell Attri_valu= rw_obj.getCell(1);
						   return Attri_valu.toString();
				      }
			   }
			return null;		  
		}

}
