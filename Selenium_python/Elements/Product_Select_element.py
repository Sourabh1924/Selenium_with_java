'''
Created on Apr 12, 2018

@author: Ideliver
'''

#from POM.page import BasePage
from POM.Product_Select_POM import ProductPage

class Product_Page(object):

    '''Product Select Module'''
    def Product_Select(self,driver):

#         Base = BasePage()
#         
#         Base.ClickMainProduct(driver)
#         First_Price =  Base.Get_Product_Price(driver)
#         Base.ClickSubProduct(driver)
#         Base.ClickColor(driver)
#         Base.ClickAddProduct(driver)
#         Base.ClickCheckOut(driver)   
#         return First_Price
    
    
        Product = ProductPage()
        
        Product.ClickMainProduct(driver)
        First_Price =  Product.Get_Product_Price(driver)
        Product.ClickSubProduct(driver)
        Product.ClickColor(driver)
        Product.ClickAddProduct(driver)
        Product.ClickCheckOut(driver)   
        return First_Price
    