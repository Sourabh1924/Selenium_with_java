package package_4;

import org.openqa.selenium.By;
import libraries.Local_libraries;

public class Element_lab3 {

	public By Enroll_button() throws Throwable
	{
		By Enroll = By.xpath(Local_libraries.GetElement_Enroll("xpath_enroll_num", "Enroll_properties"));
		return Enroll;
	}
	public By First_name() throws Throwable
	{
		By First = By.cssSelector(Local_libraries.GetElement_Enroll("css_First_name", "Enroll_properties"));
		return First;
	}
	public By Middle_name() throws Throwable
	{
		By Middle = By.cssSelector(Local_libraries.GetElement_Enroll("css_Middle_name", "Enroll_properties"));
		return Middle;
	}
	public By Last_name() throws Throwable
	{
		By Last = By.cssSelector(Local_libraries.GetElement_Enroll("css_Last_name", "Enroll_properties"));
		return Last;
	}
	public By DOB_month() throws Throwable
    {
		By Month = By.cssSelector(Local_libraries.GetElement_Enroll("css_DOB_month", "Enroll_properties"));
		return Month;
    }
	public By DOB_day() throws Throwable
	{
		By Day = By.cssSelector(Local_libraries.GetElement_Enroll("css_DOB_day", "Enroll_properties"));
		return Day;
	}
	public By DOB_year() throws Throwable
	{
		By Year = By.cssSelector(Local_libraries.GetElement_Enroll("css_DOB_year", "Enroll_properties"));
		return Year;
	}
	public By SSN() throws Throwable
	{
		By ssn = By.cssSelector(Local_libraries.GetElement_Enroll("css_SSN", "Enroll_properties"));
		return ssn;
	}
	public By Gender() throws Throwable
	{
		By gender = By.cssSelector(Local_libraries.GetElement_Enroll("css_Gender", "Enroll_properties"));
		return gender;
	}
	public By City() throws Throwable
	{
		By city = By.cssSelector(Local_libraries.GetElement_Enroll("css_City", "Enroll_properties"));
		return city;
	}
	public By Address() throws Throwable
	{
		By address = By.cssSelector(Local_libraries.GetElement_Enroll("css_Address", "Enroll_properties"));
		return address;
	}
	public By Zipcode() throws Throwable
	{
		By code = By.cssSelector(Local_libraries.GetElement_Enroll("css_Zipcode", "Enroll_properties"));
		return code;
	}
	public By State() throws Throwable
	{
		By state = By.cssSelector(Local_libraries.GetElement_Enroll("css_State", "Enroll_properties"));
		return state;
	}
	public By Area_code() throws Throwable
	{
		By area_code = By.cssSelector(Local_libraries.GetElement_Enroll("css_Ph_number_area_code", "Enroll_properties"));
		return area_code;
	}
	public By Prefix_num() throws Throwable
	{
		By prefix_num = By.cssSelector(Local_libraries.GetElement_Enroll("css_Ph_number_prefix_num", "Enroll_properties"));
		return prefix_num;
	}
	public By Line_num() throws Throwable
	{
		By line_num = By.cssSelector(Local_libraries.GetElement_Enroll("css_Ph_number_line_num", "Enroll_properties"));
		return line_num;
	}
	public By Email() throws Throwable
	{
		By email = By.cssSelector(Local_libraries.GetElement_Enroll("css_Email", "Enroll_properties"));
		return email;
	}
	public By Re_Email() throws Throwable
	{
		By re_Email = By.cssSelector(Local_libraries.GetElement_Enroll("css_Re_Email", "Enroll_properties"));
		return re_Email;
	}
	public By Username() throws Throwable
	{
		By username = By.cssSelector(Local_libraries.GetElement_Enroll("css_Username", "Enroll_properties"));
		return username;
	}
	public By Password() throws Throwable
	{
		By password = By.cssSelector(Local_libraries.GetElement_Enroll("css_Password", "Enroll_properties"));
		return password;
	}
	public By Re_Password() throws Throwable
	{
		By re_Password = By.cssSelector(Local_libraries.GetElement_Enroll("css_Re_Password", "Enroll_properties"));
		return re_Password;
	}
	public By Answer() throws Throwable
	{
		By answer = By.cssSelector(Local_libraries.GetElement_Enroll("css_Answer", "Enroll_properties"));
		return answer;
	}
	public By Answer1() throws Throwable
	{
		By answer = By.cssSelector(Local_libraries.GetElement_Enroll("css_Answer1", "Enroll_properties"));
		return answer;
	}
	public By Accept() throws Throwable
	{
		By accept = By.cssSelector(Local_libraries.GetElement_Enroll("css_Accept", "Enroll_properties"));
		return accept;
	}
	public By Submit() throws Throwable
	{
		By submit = By.cssSelector(Local_libraries.GetElement_Enroll("css_Submit", "Enroll_properties"));
		return submit;
	}
	public By Account_number() throws Throwable
	{
		By account_number = By.cssSelector(Local_libraries.GetElement_Enroll("css_Account_number", "Enroll_properties"));
		return account_number;
	}
	public By Cust_name() throws Throwable
	{
		By cust_name = By.cssSelector(Local_libraries.GetElement_Enroll("css_Cust_name", "Enroll_properties"));
		return cust_name;
	}
}
