#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 19
"""


# 5 键盘事件
# Key()类提供方法

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

# 数据初始化
base_url = "http://www.baidu.com"
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 输入框输入内容
kw1 = browser.find_element_by_id('kw1')
kw1.send_keys('seleniumm')
time.sleep(3)

# 删除一个m
kw1.send_keys(Keys.BACK_SPACE)
time.sleep(3)

# 输入空格键和“教程”
kw1.send_keys(Keys.SPACE)
kw1.send_keys(u'教程')
time.sleep(3)

# ctrl + a 全选输入框内容
kw1.send_keys(Keys.CONTROL, 'a')
time.sleep(3)

# ctrl + x 剪切输入框内容
kw1.send_keys(Keys.CONTROL, 'x')
time.sleep(3)

# 在输入框中，ctrl + v 粘贴内容
kw1.send_keys(Keys.CONTROL, 'v')
time.sleep(3)

# 回车键 代替 click（）
kw1.send_keys(Keys.ENTER)
time.sleep(3)

# 浏览器退出
browser.quit()

