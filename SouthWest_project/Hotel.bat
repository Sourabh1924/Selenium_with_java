ECHO OFF
cd F:\Sel\SouthWest_project
set classpath=F:\Sel\SouthWest_project\bin;F:\Sel\SouthWest_project\Selenium_Jars\*;
java org.testng.TestNG Hotel.xml
PAUSE