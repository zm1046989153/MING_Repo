#_*_ coding=utf-8 _*_

from selenium import webdriver
import unittest
from pages import *

class TestPages(unittest.TestCase):
    def setUp(self):
        self.driver=webdriver.Firefox()
        self.driver.maximize_window()
        self.driver.get("http://192.168.1.36:8080/ISS10/index.jsp")


    def login(self):
        page=LoginPage(self.driver)
        page.enter_username().send_keys("ROOT")
        page.enter_password().send_keys("ROOT")

        page.loginbutton().click()

        self.assertTrue(page.check_page_loaded())

            
    def test_com_sort(self):

        self.login()
        
        page=MainPage(self.driver)
        #进入商品分类界面
        page.go_to_com_sort_page()
            
  

'''

    def tearDown(self):
        self.driver.close()
        self.driver.quit()
'''

if __name__ == "__main__":
    
    unittest.main()
