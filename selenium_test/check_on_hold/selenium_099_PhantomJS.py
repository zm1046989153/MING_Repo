#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 23
"""

from selenium import webdriver

# 需要安装phantomjs.exe
driver = webdriver.PhantomJS()
# 打开url
driver.get("http://www.baidu.com")
# 定位
data = driver.find_element_by_id("cp").text
print data
