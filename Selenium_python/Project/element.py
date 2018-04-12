'''
Created on Mar 26, 2018
@author: Ideliver
'''

from Project.page import BasePage

class Element_Page(object):
   
    '''Product Select Module'''
    def Product_Select(self,driver):

        Base = BasePage()
        
        Base.ClickMainProduct(driver)
        First_Price =  Base.Get_Product_Price(driver)
        Base.ClickSubProduct(driver)
        Base.ClickColor(driver)
        Base.ClickAddProduct(driver)
        Base.ClickCheckOut(driver)   
        return First_Price
        
    '''User Login Module'''
    def Login(self,driver,Price,Username,Password):
        
        Base = BasePage()
        
        Second_Price = Base.Verify_Product_Price(driver,Price)
        Base.EnterUsername(driver,Username)
        Base.EnterPassword(driver,Password)
        Base.ClickLogin_button(driver)  
        return Second_Price
        
    '''Payment Module'''
    def Payment(self,driver,Price,SafePay_Username,SafePay_Password):
        
        Base = BasePage()
        
        Base.Payment_Product_Price(driver, Price)
        Base.ClickNext_button(driver)
        Base.SelectSafpay(driver)
        Base.EnterSafpay_Username(driver,SafePay_Username)
        Base.EnterSafpay_Password(driver,SafePay_Password)
        Base.ClickPaynow(driver)
        Base.Check_Tracking_Number(driver)
    