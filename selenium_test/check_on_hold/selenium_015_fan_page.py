#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""

# 15 分页处理


from selenium import webdriver
import os
import time


# 数据初始化
base_url = os.path.dirname(__file__) + '/html/' + 'fan_page.html'
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 计算页数
total_pages = browser.find_element_by_tag_name('select').find_elements_by_tag_name('option')
print "一共%s页" %(len(total_pages))

# 分页轮流点击
for page in total_pages:
    page.click()
    time.sleep(3)

# 退出浏览器
browser.quit()