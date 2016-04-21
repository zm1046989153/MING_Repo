#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 19
"""

# 5 打印消息
# title
# current_url
# 通过一些差异的信息进行断言

from selenium import webdriver
import time

# 数据初始化
base_url = 'http://www.baidu.com'
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 当前浏览器tab的title和url
title_ = browser.title
url_ = browser.current_url

# 断言
assert u'百度' in title_
assert 'baidu' in url_

# 浏览器退出
browser.quit()