'''
Created on Mar 20, 2018

@author: Ideliver
'''

from selenium import webdriver
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.common.by import By

      
def setup(self):
    driver = self.driver
driver = webdriver.Chrome(executable_path="E:\Sourabh_Selenium\Sel\Selenium_python\Driver\chromedriver.exe")
URL = "http://www.advantageonlineshopping.com/#/"
driver.get(URL)

def ProductSelection(self, WebDriverWait,expected_conditions):
    driver = self.driver
    self.WebDriverWait = WebDriverWait
    self.expected_conditions = expected_conditions
    WebDriverWait(driver,30).until(expected_conditions.presence_of_element_located((By.ID,"speakersImg")))   
driver.find_element_by_id("speakersImg").click()  
driver.find_element_by_xpath("//a[contains(text(),'Bose Soundlink Bluetooth Speaker III')]").click()
driver.find_element_by_xpath("//span[contains(@class,'GRAY')]").click()
driver.find_element_by_xpath("//button[contains(text(),'ADD TO CART')]").click()
driver.find_element_by_name("checkOutPopUp").click()

def Flight_Booking(self):
    driver = self.driver
driver.find_element_by_xpath("//input[@value='oneway']").click()
select = Select(driver.find_element_by_xpath("//select[@name='passCount']")) 
select.select_by_value("2")
select = Select(driver.find_element_by_xpath("//select[@name='fromPort']")) 
select.select_by_value("New York")
select = Select(driver.find_element_by_xpath("//select[@name='fromMonth']")) 
select.select_by_value("2")
select = Select(driver.find_element_by_xpath("//select[@name='fromDay']")) 
select.select_by_value("2")
driver.find_element_by_xpath("//input[@value='First']").click()
driver.find_element_by_xpath("//input[@name='findFlights']").click()

def Close(self):
    driver = self.driver
driver.close()
driver.quit()

