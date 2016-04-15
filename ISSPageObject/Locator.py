#_*_ coding:utf-8 _*_

from selenium.webdriver.common.by import By

class  LoginPageLocator(object):
    #帐号、密码输入框
    USERNAME        = (By.NAME, "stmUserPwd.fdName")
    PASSWORD        = (By.NAME, "stmUserPwd.fdPassword")

    #登录、重置按钮
    LOGINBUTTON     = (By.CSS_SELECTOR, "#buttonLogin")
    RESETBUTTON     = (By.ID, "buttonReset")

    #定位欢迎使用位置，可用于断言界面是否刷新完成或是否正常进入系统
    HEADER          = (By.CSS_SELECTOR, "#content > div.tabs-panels.tabs-panels-noborder > div > div > div > h5")


class MenuTreeLocator(object):

    #订单管理
    ORDER           = (By.CSS_SELECTOR, "#menuAccordion > div:nth-child(1) > div.panel-header.accordion-header > div.panel-title")
 
    #会员信息
    MEMBER          = (By.CSS_SELECTOR, "#menuAccordion > div:nth-child(2) > div.panel-header.accordion-header > div.panel-title")

    #基础信息
    BASIC           = (By.CSS_SELECTOR, "#menuAccordion > div:nth-child(3) > div.panel-header.accordion-header > div.panel-title")

    ##商品类别
    COMSORT         = (By.CSS_SELECTOR, "#menuAccordion > div:nth-child(3) > div.panel-body.accordion-body li:nth-child(4) > div > span:nth-child(3)")
    

    #系统管理
    SYSTEM          =(By.CSS_SELECTOR, "")

    #促销方案管理
    PROMOTION       =(By.CSS_SELECTOR, "")
    

    
