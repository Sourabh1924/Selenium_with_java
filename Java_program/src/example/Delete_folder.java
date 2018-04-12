package example;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class Delete_folder {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		File file = new File("F:\\Sel\\Hotmail_project\\src\\Test_Result");
		File[] files = file.listFiles();
		    for(File eachfile: files)   
		    {
		    	File Subfile = new File(eachfile.getAbsolutePath());
		    	DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    	//Find the file last modified date 
		    	Date lastModified_date = sdf.parse( sdf.format(eachfile.lastModified()));
		    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    	//File the current date
		    	Date Current_date = dateFormat.parse(dateFormat.format(new Date()));
		    	
			   	   	if (Current_date.compareTo(lastModified_date) > 0) 
			   	   	{
			   	   		FileUtils.deleteDirectory(new File(Subfile.getAbsolutePath()));
			   	   	}
		    }
	}
}
