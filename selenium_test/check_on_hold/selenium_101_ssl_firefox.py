#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 11
"""

#  自签名证书（firefox）

from selenium import webdriver
import time

# 数据初始化
# url2 = "https://www.cacert.org/"
url2 = "https://vpn.rfchina.com/"

# 定义firefox配置
profile = webdriver.FirefoxProfile()
profile.accept_untrusted_certs = True
browser = webdriver.Firefox(firefox_profile=profile)

# 打开浏览器
browser.get(url2)
browser.maximize_window()
time.sleep(3)




# 关闭浏览器
browser.close()