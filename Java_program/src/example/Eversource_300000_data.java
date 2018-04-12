package example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

@Test
public class Eversource_300000_data {

  ArrayList<String> Data_save_array=new ArrayList<String>(); 
    
	public static void main(String[] args) throws Throwable, Throwable, IOException
   {
		
    	FileInputStream Eversource_collection_data_inputstream = new FileInputStream("C:\\Users\\Sourabh\\Downloads\\Eversource_collection_data.xlsx");
    	Workbook WB_collection_data =WorkbookFactory.create(Eversource_collection_data_inputstream);
    	//Workbook  WB_collection_data = StreamingReader.builder().sstCacheSize(100).open(Eversource_collection_data_inputstream); 
    	Sheet DATA = WB_collection_data.getSheet("DATA");
    	
    	FileInputStream Eversource_data_inputstream = new FileInputStream("C:\\Users\\Sourabh\\Downloads\\eversource_customes_12142017.xlsx");
        Workbook wb=WorkbookFactory.create(Eversource_data_inputstream);
        Sheet CT = wb.getSheet("CT");       
        Sheet WMA = wb.getSheet("WMA");
        Sheet NH = wb.getSheet("NH");
        Sheet EMA = wb.getSheet("EMA");
        Eversource_300000_data obj = new Eversource_300000_data();       
	        for(int No_of_row=1;No_of_row<10;No_of_row++)
	        {
	            obj.Get(DATA, CT, No_of_row, WB_collection_data);
	            obj.Get(DATA, WMA, No_of_row, WB_collection_data);
	            obj.Get(DATA, NH, No_of_row, WB_collection_data);
	            obj.Get(DATA, EMA, No_of_row, WB_collection_data);
	            obj.Get(DATA, EMA, No_of_row+1, WB_collection_data);
	        }
	        WB_collection_data.close();
   }
        
    public void Get(Sheet DATA, Sheet Data_sheet, int index, Workbook WB_collection_data) throws Throwable
    {  	
       
        Row rw = Data_sheet.getRow(index);
            for(int Read_cell=0;Read_cell<=12;Read_cell++)
            {
                Cell cell = rw.getCell(Read_cell);
                if(cell.toString().equalsIgnoreCase("null")) 
                {
                	Data_save_array.add("");
                }
                else
                {
                	Data_save_array.add(cell.toString());
                }                            
            }
               
        Eversource_300000_data obj = new Eversource_300000_data();
        obj.Set(Data_save_array, DATA, WB_collection_data);
        Data_save_array.clear();
    } 
    
    public  void Set(ArrayList<String> Data_save_array, Sheet DATA, Workbook WB_collection_data) throws Throwable
    {
    	 int Row_cnt = DATA.getLastRowNum();
    	 Row row = DATA.createRow(Row_cnt+1);
	    	for(int index=0;index<=12;index++)
	        {      
	    		row.createCell(index).setCellValue(Data_save_array.get(index));
	        }
	        FileOutputStream Eversource_collection_data_outStream = new FileOutputStream("C:\\Users\\Sourabh\\Downloads\\Eversource_collection_data.xlsx");
	        WB_collection_data.write(Eversource_collection_data_outStream);	        
    }
}
