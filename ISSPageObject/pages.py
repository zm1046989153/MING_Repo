from  Locator import *
from base import Page
import time
from time import sleep

class LoginPage(Page):
    
    def enter_username(self):
        return self.find_element(*LoginPageLocator.USERNAME)

    def enter_password(self):
        return self.find_element(*LoginPageLocator.PASSWORD)

    def loginbutton(self):
        return self.find_element(*LoginPageLocator.LOGINBUTTON)

    def resetbutton(self):
        return self.find_element(*LoginPageLocator.RESETBUTTON)
    
    def check_page_loaded(self):
        return self.wait_for_element(*LoginPageLocator.HEADER)

class MainPage(Page):

    def go_to_com_sort_page(self):

        self.find_element(*MenuTreeLocator.BASIC).click()
        sleep(3)

        self.find_element(*MenuTreeLocator.COMSORT).click()
  
        
    
    

