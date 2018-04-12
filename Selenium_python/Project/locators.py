'''
Created on Mar 26, 2018

@author: Ideliver
'''

class Locators(object):
   
    '''Product page Locators'''
    Product          = "speakersImg"   
    SubProduct       = "//a[contains(text(),'Bose Soundlink Bluetooth Speaker III')]" 
    SubProduct_Price = "//a[contains(text(),'Bose Soundlink')]/ancestor::p/following-sibling::p/descendant::a[@class='productPrice ng-binding']"   
    Product_Color    = "//span[contains(@class,'GRAY')]"    
    Add_Product      = "//button[contains(text(),'ADD TO CART')]"  
    CheckOut         = "//button[contains(text(),'CHECKOUT')]"
    
    '''Login page Locators'''  
    Price       = "//span[contains(@class,'totalValue ng-binding')]" 
    Username    = "usernameInOrderPayment"
    Password    = "passwordInOrderPayment"
    Login       = "login_btnundefined"
    
    '''Payment page Locators'''
    Price            = "//span[contains(@class,'totalValue ng-binding')]" 
    Next_Button      = "next_btn"
    Safpay_RButton   = "safepay"
    Saf_User         = "safepay_username"
    Saf_Pass         = "safepay_password"
    Pay_Button       = "pay_now_btn_SAFEPAY"
    Track_Number = "trackingNumberLabel"
    