'''
Created on Mar 26, 2018

@author: Ideliver
'''
from selenium.webdriver.common.by import By
from Locators.locators import Locators
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from time import sleep
from Libraries.ScreenShort_Lab import Screen_Short

class BasePage(object):
                         
        '''--------------------------------------------------------------------'''
        '''--------------------------------------------------------------------'''     
        '''Product Select POM'''                              
        '''self.MainProduct  = driver.find_element(By.ID,Locators.Product)       
        self.SubProduct   = driver.find_element(By.XPATH,Locators.SubProduct)       
        self.Color        = driver.find_element(By.XPATH,Locators.Product_Color)
        self.AddProduct   = driver.find_element(By.XPATH,Locators.Add_Product)
        self.CheckOut     = driver.find_element(By.XPATH,Locators.CheckOut)'''
        
        def ClickMainProduct(self,driver):       
            WebDriverWait(driver,30).until(expected_conditions.visibility_of_element_located((By.ID,Locators.Product))) 
            Screen_Short.ScreenShot(self,driver)
            driver.find_element(By.ID,Locators.Product).click()
        
        def Get_Product_Price(self,driver):
            WebDriverWait(driver,30).until(expected_conditions.visibility_of_element_located((By.XPATH,Locators.SubProduct)))
            sleep(5)
            Price = driver.find_element(By.XPATH,Locators.SubProduct_Price)
            return Price.text
        
        def ClickSubProduct(self,driver):
            Screen_Short.ScreenShot(self,driver)            
            driver.find_element(By.XPATH,Locators.SubProduct).click()
        
        def ClickColor(self,driver):           
            sleep(4)
            Screen_Short.ScreenShot(self,driver)
            driver.find_element(By.XPATH,Locators.Product_Color).click()
        
        def ClickAddProduct(self,driver):            
            driver.find_element(By.XPATH,Locators.Add_Product).click()
        
        def ClickCheckOut(self,driver): 
            sleep(2)  
            Screen_Short.ScreenShot(self,driver)         
            driver.find_element(By.XPATH,Locators.CheckOut).click() 
        
        '''--------------------------------------------------------------------'''
        '''--------------------------------------------------------------------'''
        '''Login POM '''
        '''self.Username     = driver.find_element(By.NAME,Locators.Username)
        self.Password     = driver.find_element(By.NAME,Locators.Password)
        self.Login_button = driver.find_element(By.ID,Locators.Login)'''
        
        def Verify_Product_Price(self,driver,Price):
            sleep(5)
            VerifyPrice = driver.find_element(By.XPATH,Locators.Price)
            try:
                if VerifyPrice.text == Price:
                    print("Both the Price are same")
                    print("First price : "+Price+" Second price : "+VerifyPrice.text+" .")
                    return VerifyPrice.text
            except Exception as e:

                    print("ERROR : Both the Price are not same")
                    print("ERROR DESCRIPTION : "+e)
                    print("First price : "+Price+" Second price : "+VerifyPrice.text+" .")  
                    return VerifyPrice.text               
        
        def EnterUsername(self,driver,Username):                       
            driver.find_element(By.NAME,Locators.Username).send_keys(Username) 
        
        def EnterPassword(self,driver,Password):           
            driver.find_element(By.NAME,Locators.Password).send_keys(Password)          
        
        def ClickLogin_button(self,driver): 
            Screen_Short.ScreenShot(self,driver)          
            driver.find_element(By.ID,Locators.Login).click()            
           
        '''--------------------------------------------------------------------'''
        '''--------------------------------------------------------------------'''
        '''Payment POM '''        
        '''self.Next_button     = driver.find_element(By.ID,Locators.Next_Button)
        self.Safpay          = driver.find_element(By.NAME,Locators.Safpay_RButton)
        self.Safpay_Username = driver.find_element(By.NAME,Locators.Saf_User)
        self.Safpay_Password = driver.find_element(By.NAME,Locators.Saf_Pass)
        self.Paynow          = driver.find_element(By.ID,Locators.Pay_Button)'''
            
        def Payment_Product_Price(self,driver,Price):
            sleep(5)
            VerifyPrice = driver.find_element(By.XPATH,Locators.Price)
            try:
                if VerifyPrice.text == Price:
                    print("Both the Price are same")
                    print("First price : "+Price+" Second price : "+VerifyPrice.text+" .")   
            except Exception as e:

                    print("ERROR : Both the Price are not same")
                    print("ERROR DESCRIPTION : "+e)
                    print("First price : "+Price+" Second price : "+VerifyPrice.text+" .")  
                    return VerifyPrice.text 
                
        def ClickNext_button(self,driver):
            sleep(5)  
            Screen_Short.ScreenShot(self,driver)
            driver.find_element(By.ID,Locators.Next_Button).click()
         
        def SelectSafpay(self,driver):
            driver.find_element(By.NAME,Locators.Safpay_RButton).click()
         
        def EnterSafpay_Username(self,driver,SafePay_Username):
            driver.find_element(By.NAME,Locators.Saf_User).clear()
            driver.find_element(By.NAME,Locators.Saf_User).send_keys(SafePay_Username)
         
        def EnterSafpay_Password(self,driver,SafePay_Password):
            driver.find_element(By.NAME,Locators.Saf_Pass).clear()
            driver.find_element(By.NAME,Locators.Saf_Pass).send_keys(SafePay_Password) 
        
        def ClickPaynow(self,driver):
            Screen_Short.ScreenShot(self,driver)
            driver.find_element(By.ID,Locators.Pay_Button).click() 
        
        def Check_Tracking_Number(self,driver):
            Track = driver.find_element(By.ID,Locators.Pay_Button) 
            try:
                if(Track.text!=""):
                    Screen_Short.ScreenShot(self,driver)
                    print("Product booked successfully : "+Track.text)
            except Exception as e:

                Screen_Short.ScreenShot(self,driver)
                print("ERROR DESCRIPTION : "+e)
                print("Order is not booked")       