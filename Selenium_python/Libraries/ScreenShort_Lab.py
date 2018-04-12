'''
Created on Mar 29, 2018

@author: Ideliver
'''

import unittest
import datetime


class Screen_Short(unittest.TestCase):

    def ScreenShot(self,driver):
             
        Filename = str(datetime.datetime.now()).replace("-", "")
        driver.get_screenshot_as_file("E:\Sourabh_Selenium\Sel\Selenium_python\ScreenShort"+Filename+".png")
        