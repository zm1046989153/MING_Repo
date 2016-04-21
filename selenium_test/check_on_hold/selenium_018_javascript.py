#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""


# 18 调用javascript

from selenium import webdriver

# 初始化数据
browser = webdriver.Chrome()
js = "return document.title"

# 打开url
browser.get("http://www.baidu.com")

print browser.execute_script(js)

# 退出浏览器
browser.quit()
