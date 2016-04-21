#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 19
"""


# 7 设置等待时间
# sleep() 固定时间
# implicitly_wait() 隐性等待
# WebDriverWait()  一段时间内，检查元素是否存在。

from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
import time

# 数据初始化
base_url = "http://www.baidu.com"
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# WebDriverWait()方法使用 和until, until_not 搭配
element = WebDriverWait(browser, 10).until(lambda b: browser.find_element_by_id('kw1'))
element.send_keys('selenium')


# 智能等待
browser.implicitly_wait(30)
browser.find_element_by_id('su1').click()

# 固定时间
time.sleep(3)

# 浏览器退出
browser.quit()