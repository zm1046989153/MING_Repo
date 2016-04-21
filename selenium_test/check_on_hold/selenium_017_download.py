#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""

# 17 下载文件（firefox）

from selenium import webdriver
import os
import time


# 数据初始化
base_url = "http://music.baidu.com/cms/mobile/static/apk/Baidu_Music.apk"
# 定义firefox配置
firefox_profile = webdriver.FirefoxProfile()
# 保存文件夹位置：最新保存的文件夹
firefox_profile.set_preference("browser.download.folderList", 2)
# 最新保存的文件夹
down_list = os.getcwd() + "\\" + "html"
firefox_profile.set_preference("browser.download.dir", down_list)
# 下载文件的类型
firefox_profile.set_preference("browser.helperApps.neverAsk.saveToDisk",
                               "application/vnd.android.package-archive")
# 加载firefox_profile
browser = webdriver.Firefox(firefox_profile)

apk_file = down_list + "\\" + "Baidu_Music.apk"
# 删除下载好的文件
if os.path.isfile(apk_file) is True:
    os.remove(apk_file)
    time.sleep(2)

browser.get(base_url)
time.sleep(60)
if os.path.isfile(apk_file) is True:
    print u"下载ok"

# 退出浏览器
browser.quit()


