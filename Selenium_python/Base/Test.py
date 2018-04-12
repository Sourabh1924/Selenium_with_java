'''
Created on Mar 20, 2018

@author: Ideliver
'''

from selenium import webdriver
from selenium.webdriver.support.ui import Select


driver = webdriver.Chrome(executable_path="E:\Sourabh_Selenium\Sel\Selenium_python\Driver\chromedriver.exe")
URL = "http://www.newtours.demoaut.com/"
driver.get(URL)
driver.find_element_by_name("userName").send_keys("agent")
driver.find_element_by_name("password").send_keys("mercury")
driver.find_element_by_name("login").click()
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
driver.close()
driver.quit()

