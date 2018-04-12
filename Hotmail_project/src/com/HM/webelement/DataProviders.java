package com.HM.webelement;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import com.HM.libraries.Excel_libraries;

public class DataProviders {

	static String File_path = "E:\\Sourabh_Selenium\\Sel\\Hotmail_project\\Project_Data\\HM_Data_sheet_iteration.xls";
	
	  @DataProvider(name = "Send_Mail_Data")
	  public static Object[][] createData() {
		 Object[][] testObjArray;
		try {
			testObjArray = Excel_libraries.Read_Data_itera(File_path, "Send_mail");
			return testObjArray;
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;				
	  }
}
