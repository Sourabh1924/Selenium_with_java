'''
Created on Mar 29, 2018

@author: Ideliver
'''

from unittest import TestLoader, TestSuite, TextTestRunner
from Project.Test import Test


if __name__ == "__main__":

    loader = TestLoader()
    suite = TestSuite((
        loader.loadTestsFromTestCase(Test),

        ))
#run test sequentially using simple TextTestRunner
    runner = TextTestRunner(verbosity=2)
    runner.run(suite)