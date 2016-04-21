#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 19
"""

# 13 javascript的弹窗

from selenium import webdriver
import os
import time

# 数据初始化
base_url = os.path.dirname(__file__) + '/html/' ++ 'alert.html'
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 定位并点击 alert 按钮
browser.find_element_by_id('alert').click()
time.sleep(3)
# 确认alert
browser.switch_to.alert.accept()
time.sleep(3)

# 定位并点击 confirm 按钮
browser.find_element_by_id('confirm').click()
time.sleep(3)
# 确认confirm
browser.switch_to.alert.accept()
time.sleep(3)

# 定位并点击 confirm 按钮
browser.find_element_by_id('confirm').click()
time.sleep(3)
# 取消 confirm
browser.switch_to.alert.dismiss()
time.sleep(3)

# 定位并点击 prompt 按钮
browser.find_element_by_id('prompt').click()
time.sleep(3)
# 往prompt窗口中输入值
browser.switch_to.alert.send_keys("test")
time.sleep(3)
# 确认prompt
browser.switch_to.alert.accept()
time.sleep(3)

# 退出浏览器
browser.quit()


