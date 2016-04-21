#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""

# 12 多浏览器窗口处理

from selenium import webdriver
import time

# 数据初始化
browser = webdriver.Chrome()
base_url = 'http://www.youdao.com'

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 获取当前窗口的句柄
handle_1 = browser.current_window_handle

# 新标签中打开有道字典
browser.find_element_by_class_name('dict').click()

# 获取所有窗口的句柄
handle_all = browser.window_handles
handle_now = browser.current_window_handle
# 循环判断窗口是否为“有道字典”的窗口
for handle in handle_all:
    if handle != handle_1:
        browser.switch_to.window(handle)
        print "switch to youdao dict"
        time.sleep(3)
        # 关闭浏览器tab
        browser.close()

# 回到浏览器初始tab
browser.switch_to.window(handle_1)
browser.find_element_by_class_name('dict')

# 关闭浏览器
browser.quit()



