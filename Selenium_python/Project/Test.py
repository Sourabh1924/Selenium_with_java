'''
Created on Mar 26, 2018

@author: Ideliver
'''

import unittest
from Project.element import Element_Page
from Project.Environment_Setup import Setup
from Project.ScreenShort_Lab import Screen_Short
#from Project import HTML_Report

class Test(unittest.TestCase):

    def test_search_in_python_org(self):
        
        '''-------------------------Variable initialization-------------------------'''
        '''-------------------------------------------------------------------------'''
        URL                 = "http://www.advantageonlineshopping.com/#/"
        Browser             = "Chrome"
        Username            = "iDeliver"  
        Password            = "iDeliver@1"
        SafePay_Username    = "iDeliver"
        SafePay_Password    = "iDeliver1"
        
        '''-------------------------------SetUp Module------------------------------'''
        '''-------------------------------------------------------------------------'''
        '''Environment SetUp page object is created''' 
        Setup_Page = Setup()
        '''Driver instance transfer to "driver"'''
        driver = Setup_Page.setUp(URL,Browser)
        Screen_Short.ScreenShot(self, driver)
        '''-------------------------------------------------------------------------'''
        '''-------------------------------------------------------------------------'''
        
        
        '''--------------------------Product Booking Module-------------------------'''
        '''-------------------------------------------------------------------------'''
        '''Element page object is created'''      
        Element_Obj = Element_Page()
        '''Product module is calling'''
        First_Price = Element_Obj.Product_Select(driver)
        '''Login module is calling'''
        Second_Price = Element_Obj.Login(driver,First_Price,Username,Password)
        '''Payment module is calling'''
        Element_Obj.Payment(driver,Second_Price,SafePay_Username,SafePay_Password)
        '''-------------------------------------------------------------------------'''
        '''-------------------------------------------------------------------------'''
        
        
        '''--------------------------------Close Module-----------------------------'''
        '''-------------------------------------------------------------------------'''
        '''Driver instance is close'''
        Setup_Page.tearDown(driver)   
        '''-------------------------------------------------------------------------'''
        '''-------------------------------------------------------------------------'''
        
if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()