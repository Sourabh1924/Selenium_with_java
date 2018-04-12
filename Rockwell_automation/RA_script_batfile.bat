
ECHO OFF
cd F:\Sel\Rockwell_automation
set classpath=F:\Sel\Rockwell_automation\bin;C:\Java_jar\*;
java org.testng.TestNG RA_script.xml
PAUSE