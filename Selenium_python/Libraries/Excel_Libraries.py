'''
Created on Apr 12, 2018

@author: Ideliver
'''
import xlrd

class ExlFunction(object):
    
    def Excel_read(self):
      wb2 = xlrd.open_workbook('D:\\test_logs\\Spreadsheet_test.xls')
      sheet1 = wb2.sheet_by_name('Sheet 1')
        