#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 23
"""

# 点击空白区域：坐标（0,0）

from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains

browser = webdriver.Chrome()
browser.get("http://www.baidu.com")
ActionChains(browser).move_by_offset(0, 0).click().perform()

