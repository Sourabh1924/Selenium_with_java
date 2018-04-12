package make_my_trip;

import org.openqa.selenium.By;

public class Element_libraries {
		
//----------------------------------------------------Flight search ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------		
		
		public By Src_element() throws Throwable
		{
			By Source = By.id(Function_libraries.GetElement("id_from", "Properties"));
			return Source;
		}
			
		public By Des_element() throws Throwable
		{
			By Destination = By.id(Function_libraries.GetElement("id_to", "Properties"));
			return Destination;
		}
		
		public By Date_Butn_element() throws Throwable
		{
			By Button = By.id(Function_libraries.GetElement("id__click_depar", "Properties"));
			return Button;
		}
		
		public By Date_element() throws Throwable
		{
			By Date_click = By.partialLinkText(Function_libraries.GetElement("Click_date", "Properties"));
			return Date_click;
		}
		
		public By Pass_Butn_element() throws Throwable
		{
			By Pass_click = By.id(Function_libraries.GetElement("id_click_passcnt", "Properties"));
			return Pass_click;
		}
		
		public By Select_pass_element() throws Throwable
		{
			By Passenger = By.xpath(Function_libraries.GetElement("xpath_pass_select", "Properties"));
			return Passenger;
		}
		
		public By Click_butn_element() throws Throwable
		{
			By Click_done = By.xpath(Function_libraries.GetElement("xpath_done", "Properties"));
			return Click_done;
		}
		
		public By Click_class_element() throws Throwable
		{
			By Click_class = By.id(Function_libraries.GetElement("id_class_click", "Properties"));
			return Click_class;
		}
		
		public By Select_class_element() throws Throwable
		{
			By Click_class = By.xpath(Function_libraries.GetElement("xpath_class_select", "Properties"));
			return Click_class;
		}
		
		public By Click_search_element() throws Throwable
		{
			By Click_button = By.id(Function_libraries.GetElement("id_search", "Properties"));
			return Click_button;
		}
	
//----------------------------------------------------Flight book ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------		

		public By Click_filter_element() throws Throwable
		{
			By Click_button = By.xpath(Function_libraries.GetElement("xpath_filter", "Properties"));
			return Click_button;
		}
		
		public By Price_element() throws Throwable
		{
			By price = By.xpath(Function_libraries.GetElement("xpath_price", "Properties"));
			return price;
		}
		
		public By Book_element() throws Throwable
		{
			By Book = By.xpath(Function_libraries.GetElement("xpath_book", "Properties"));
			return Book;
		}
		
//----------------------------------------------------Fare details------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------				

		public By Base_fare_element() throws Throwable
		{
			By Base_fare = By.xpath(Function_libraries.GetElement("xpath_Base_fare", "Properties"));
			return Base_fare;
		}
		
		public By Tax_element() throws Throwable
		{
			By Tax = By.xpath(Function_libraries.GetElement("xpath_Tax", "Properties"));
			return Tax;
		}
		
		public By Total_price_element() throws Throwable
		{
			By Total = By.xpath(Function_libraries.GetElement("xpath_total", "Properties"));
			return Total;
		}
		
		public By Email_element() throws Throwable
		{
			By Email = By.xpath(Function_libraries.GetElement("xpath_Email", "Properties"));
			return Email;
		}
		
		public By Continu_element() throws Throwable
		{
			By Continu = By.xpath(Function_libraries.GetElement("xpath_Continu", "Properties"));
			return Continu;
		}
		
//----------------------------------------------------Passenger details ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------------------------------------------------------------------------------------		
		
		public By Fname_element() throws Throwable
		{
			By Fname = By.xpath(Function_libraries.GetElement("xpath_fname", "Properties"));
			return Fname;
		}
		
		public By Lname_element() throws Throwable
		{
			By Lname = By.xpath(Function_libraries.GetElement("xpath_lname", "Properties"));
			return Lname;
		}
		
		public By Fgender_element() throws Throwable
		{
			By female = By.xpath(Function_libraries.GetElement("xpath_female", "Properties"));
			return female;
		}
		
		public By Mgender_element() throws Throwable
		{
			By male = By.xpath(Function_libraries.GetElement("xpath_male", "Properties"));
			return male;
		}
		
		public By Ph_element() throws Throwable
		{
			By mobile = By.xpath(Function_libraries.GetElement("xpath_ph", "Properties"));
			return mobile;
		}
		
		public By Payment_element() throws Throwable
		{
			By Pay_button = By.xpath(Function_libraries.GetElement("xpath_payment", "Properties"));
			return Pay_button;
		}
		
		public By Payment_type_element() throws Throwable
		{
			By Card = By.xpath(Function_libraries.GetElement("xpath_debit_card", "Properties"));
			return Card;
		}
		
//----------------------------------------------------Payment details ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------		
		
		public By Select_bank_element() throws Throwable
		{
			By Card = By.id(Function_libraries.GetElement("id_select_bank", "Properties"));
			return Card;
		}
		
		public By Card_num_element() throws Throwable
		{
			By Card_num = By.id(Function_libraries.GetElement("id_card_num", "Properties"));
			return Card_num;
		}
		
		public By Holder_name_element() throws Throwable
		{
			By Holder_name = By.id(Function_libraries.GetElement("id_card_name", "Properties"));
			return Holder_name;
		}
		
		public By Expry_month_element() throws Throwable
		{
			By Month = By.id(Function_libraries.GetElement("id_exp_month", "Properties"));
			return Month;
		}
		
		public By Expry_year_element() throws Throwable
		{
			By Month = By.id(Function_libraries.GetElement("id_exp_year", "Properties"));
			return Month;
		}
		
		public By Price_check_element() throws Throwable
		{
			By Price = By.xpath(Function_libraries.GetElement("xpath_price1", "Properties"));
			return Price;
		}
				
}
