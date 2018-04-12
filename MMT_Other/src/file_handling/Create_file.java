package file_handling;

import java.io.File;

public class Create_file {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("E:\\Selenium_file_handling\\File");
		System.out.println(file.isDirectory());
		System.out.println(file.isAbsolute());
		
		System.out.println(file.getAbsolutePath());   // To get the file path
		System.out.println(file.lastModified());
		System.out.println(file.getFreeSpace());
		file.mkdirs(); 							   //To create the folder
		System.out.println(file.compareTo(new File("E:\\Selenium_file_handling\\File")));   //To compare file 
		
//		To create new file
//		File file1 = new File("E:\\Selenium_file_handling\\File\\Sam.txt");
//		file1.createNewFile();
		
		System.out.println(file.getName());   //Denote the file name
		System.out.println(file.getParentFile());   //Denote the parent file name
		System.out.println(file.getParent());		
	}

}
