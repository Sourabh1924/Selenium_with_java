'''
Created on Apr 12, 2018

@author: Ideliver
'''

from selenium.webdriver.common.by import By
from Locators.locators import Locators
from time import sleep
from Libraries.ScreenShort_Lab import Screen_Short

class PaymentPage(object):
    
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