#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 23
"""

# 连接远程

from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

base_url = "http://www.baidu.com"
browser = webdriver.Remote(
    command_executor="http://101.225.54.169:4444/wd/hub",
    desired_capabilities=DesiredCapabilities.INTERNETEXPLORER)

browser.get(base_url)