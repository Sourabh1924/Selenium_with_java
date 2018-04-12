'''
Created on Apr 12, 2018

@author: Ideliver
'''
from selenium.webdriver.common.by import By
from Locators.locators import Locators
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from time import sleep
from Libraries.ScreenShort_Lab import Screen_Short

class ProductPage(object):

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