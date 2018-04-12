package excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLiberary {
	static String Excel_path = "F:\\Sel\\Selenium\\src\\make_my_trip\\Excel_data\\MMT_data.xls";
	static Workbook WB;
	//Read data from excel file
		public static void Read(String Attri_name) throws Throwable
		{
			FileInputStream fin=new FileInputStream(Excel_path);    
			WB=WorkbookFactory.create(fin);
			Sheet sh = WB.getSheet("Sheet1");
			int Row_cnt = sh.getLastRowNum();	
			   for(int i=0;i<=Row_cnt;i++)
			   {
				   Row rw_obj = sh.getRow(i);
				   Cell cell_obj = rw_obj.getCell(0);
				   String Attri = cell_obj.toString();
				      if(Attri.endsWith(Attri_name))
				      {
						   Cell Attri_valu= rw_obj.getCell(1);
						   System.out.println(Attri_valu);
						   break;
				      }
			   }
			  
		}
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		ExcelLiberary.Read("Source");
	    }
}