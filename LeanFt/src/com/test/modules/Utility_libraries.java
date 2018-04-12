package com.test.modules;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.hp.lft.report.ModifiableReportConfiguration;
import com.hp.lft.report.ReportConfigurationFactory;

public class Utility_libraries {

	private static Workbook WB;
	static String Excel_path = "E:\\Sourabh_Selenium\\Sel\\LeanFt\\bin\\TestResult.xlsx";
	
	   public static String GetElement(String Keys,String File_name) throws Throwable
		{
			FileInputStream pagobj =null;
			Properties obj = new Properties();
			try
			{ 
				pagobj = new FileInputStream (File_name);	
			}
			catch (Exception e) 
			{	
				System.out.println("File is not found");
			}
				obj.load(pagobj);
				return obj.getProperty(Keys);
		}
	   
	   public static void Excel_Reporter(String Step_details,String Actual,String Status,String Time) throws Throwable
		{ 
			String Attribute[] =  {"Step_details","Actual","Status","Time"};
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
	   
	   public static ModifiableReportConfiguration Result() {
		
		   ModifiableReportConfiguration reportConfig = ReportConfigurationFactory.createDefaultReportConfiguration();
	        reportConfig.setOverrideExisting(true);
	        reportConfig.setTargetDirectory("RunResults"); // The folder must exist under C:\
	        reportConfig.setReportFolder("myreportdirectory");
	        reportConfig.setTitle("My Report Title");
	        reportConfig.setDescription("Report Description");
	        return reportConfig;
	}
}
