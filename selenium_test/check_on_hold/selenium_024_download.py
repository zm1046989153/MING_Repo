#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""

# 17  firefox profile（firefox）

from selenium import webdriver
import os
from time import sleep


# 数据初始化
base_url = "https://auth.alipay.com/login/index.htm"
# 定义firefox配置
firefox_profile = webdriver.FirefoxProfile()


# 保存文件夹位置：最新保存的文件夹
# firefox_profile.set_preference("browser.download.folderList", 2)
# # 最新保存的文件夹
# down_list = os.getcwd() + "\\" + "html"
# firefox_profile.set_preference("browser.download.dir", down_list)
# # 下载文件的类型
# firefox_profile.set_preference("browser.helperApps.neverAsk.saveToDisk",
#                                "application/vnd.android.package-archive")
# 加载firefox_profile
browser = webdriver.Firefox(firefox_profile)
browser.get(base_url)
sleep(5)

# 退出浏览器
browser.quit()


