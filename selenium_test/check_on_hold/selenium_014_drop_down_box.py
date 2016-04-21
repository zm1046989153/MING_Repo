#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""

# 14 下拉框处理

from selenium import webdriver
import os
import time


# 数据初始化
base_url = os.path.dirname(__file__) + '/html/' + 'drop_down.html'
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 定位到下拉框
browser.find_element_by_id('ShippingMethod').click()
time.sleep(3)

# 定位到选项
browser.find_element_by_css_selector("option[value='12.51']").click()
time.sleep(3)

# 退出浏览器
browser.quit()


