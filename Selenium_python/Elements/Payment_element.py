'''
Created on Apr 12, 2018

@author: Ideliver
'''

#from POM.page import BasePage
from POM.Payment_POM import PaymentPage

class Payment_Page(object):

    '''Payment Module'''
    def Payment(self,driver,Price,SafePay_Username,SafePay_Password):
        
#         Base = BasePage()
#         
#         Base.Payment_Product_Price(driver, Price)
#         Base.ClickNext_button(driver)
#         Base.SelectSafpay(driver)
#         Base.EnterSafpay_Username(driver,SafePay_Username)
#         Base.EnterSafpay_Password(driver,SafePay_Password)
#         Base.ClickPaynow(driver)
#         Base.Check_Tracking_Number(driver)
        
        
        Payment = PaymentPage()
        
        Payment.Payment_Product_Price(driver, Price)
        Payment.ClickNext_button(driver)
        Payment.SelectSafpay(driver)
        Payment.EnterSafpay_Username(driver,SafePay_Username)
        Payment.EnterSafpay_Password(driver,SafePay_Password)
        Payment.ClickPaynow(driver)
        Payment.Check_Tracking_Number(driver)