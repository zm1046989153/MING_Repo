#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""

# 11 div 对话框处理

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

# 数据初始化
base_url = "http://www.baidu.com/"
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 点击“登录”按钮进行登录
browser.find_element_by_name('tj_login').click()
time.sleep(3)

# 先找到登录框
browser.find_element_by_id('passport-login-pop-api')

# 再找到用户名输入框
user_name = browser.find_element_by_id('TANGRAM__PSP_8__userName')
user_name.send_keys('username')

# 再切换到密码输入框
# TAB 切换输入框
user_name.send_keys(Keys.TAB)
time.sleep(3)

browser.find_element_by_id('TANGRAM__PSP_8__password').send_keys('password')
time.sleep(3)

# 关闭浏览器
browser.quit()





