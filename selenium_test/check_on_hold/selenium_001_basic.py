#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 02
"""


# 1. 浏览器的操作
# 打印URL
# 将浏览器最大化
# 设置浏览器固定宽、高
# 操控浏览器前进、后退

from selenium import webdriver
import time  # 引入time函数
import sys

reload(sys)
sys.setdefaultencoding("utf-8")  # 修改系统编码为utf-8

# 数据初始化
browser = webdriver.Chrome()
url = "http://www.baidu.com"  # 将url分离，单独配置

# 打开浏览器
browser.get(url)

title = browser.title
print u"打开页面 %s ,页面的标题是: %s " % (url, title)  # 把页面title 打印出来
time.sleep(1)  # 休眠1秒

print u"浏览器最大化"
browser.maximize_window()  # 将浏览器最大化
time.sleep(1)  # 休眠1秒

print u"设置浏览器的宽为800，高为480"
browser.set_window_size(800, 480)  # 参数为像素值
time.sleep(1)  # 休眠1秒


browser.find_element_by_id("kw1").send_keys("selenium")
browser.find_element_by_id("su1").click()
time.sleep(1)  # 休眠1秒

# 返回操作
url2 = browser.current_url  # 搜索页地址
print url2
print u"返回到主页 %s" % url
browser.back()
time.sleep(1)  # 休眠1秒

# 前进操作
print u"前进到搜索页 %s" % url2
browser.forward()
time.sleep(1)  # 休眠1秒

# 浏览器退出
browser.quit()  # close()为关闭当前窗口，quit()为关闭所有窗口
