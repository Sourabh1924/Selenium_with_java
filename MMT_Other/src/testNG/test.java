package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {

@AfterTest
public void Atest()
{
	System.out.println("After test");
}
@BeforeTest
public void Btest()
{
	System.out.println("Before test");
}
@Test(priority=1)
public void Test1()
{
	System.out.println("Test1");
}
@Test(priority=2)
public void Test2()
{
	System.out.println("Test2");
}
@Test(priority=3)
public void Test3()
{
	System.out.println("Test3");
}
@AfterClass
public void Aclass()
{
	System.out.println("After class");
}
@BeforeClass
public void Bclass()
{
	System.out.println("Before class");
}
@AfterGroups
public void AGroup()
{
	System.out.println("After group");
}
@BeforeGroups 
public void BGroup()
{
	System.out.println("Before group");
}
@AfterMethod
public void Amethod()
{
	System.out.println("After method");
}
@BeforeMethod
public void Bmethod()
{
	System.out.println("Before method");
}
@AfterSuite
public void Asuite()
{
	System.out.println("After suite");
}
@BeforeSuite
public void Bsuite()
{
	System.out.println("Before suite");
}
}
