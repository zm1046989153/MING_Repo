#coding: utf-8

"""
@Author: Well
@Date: 2014 - 05 - 26
"""

#  自签名证书（chrome）：默认跳过验证证书

from selenium import webdriver
import time

# 数据初始化

url2 = u"https://service.fesco.com.cn/webquery/default.aspx"
browser = webdriver.Chrome()

# 打开浏览器
webdriver.DesiredCapabilities.CHROME.setdefault('accept_ssl_certs', True)

browser.get(url2)
browser.maximize_window()
time.sleep(3)

# 关闭浏览器
browser.close()