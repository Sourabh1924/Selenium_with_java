'''
Created on Mar 27, 2018

@author: Ideliver
'''
from selenium import webdriver
import datetime

class Setup(object):
    
    def setUp(self,URL,Browser):
        
        if(Browser.lower()=="firefox"):
            driver = webdriver.Firefox(executable_path="E:\Sourabh_Selenium\Sel\Selenium_python\Driver\geckodriver.exe")
        elif(Browser.lower()=="chrome"):
            driver = webdriver.Chrome(executable_path="E:\Sourabh_Selenium\Sel\Selenium_python\Driver\chromedriver.exe")
        elif(Browser.lower()=="internetexplore"): 
            driver = webdriver.Ie(executable_path="E:\Sourabh_Selenium\Sel\Selenium_python\Driver\IEDriverServer.exe")        
        print ("Run Started at : "+str(datetime.datetime.now()))
        print(Browser+" Environment Set Up")
        print("------------------------------------------------------------------")
        driver.get(URL)
        driver.implicitly_wait(20)
        driver.maximize_window()
        
        if(driver.current_url == URL):
            print("Current URL is match by given URL")
            print("------------------------------------------------------------------")   
        else:
            print("Current URL is not match by given URL"+driver.current_url+" == "+URL)
            print("------------------------------------------------------------------")
        return driver
        
    def tearDown(self,driver):
        
        if (driver!=None):
            print("------------------------------------------------------------------")
            print("Test Environment Destroyed")
            print("Run Completed at : " + str(datetime.datetime.now()))
            driver.close()
            driver.quit()