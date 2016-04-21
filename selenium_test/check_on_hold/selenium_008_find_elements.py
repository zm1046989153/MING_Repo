#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 03
"""

# 8 定位一组元素

from selenium import webdriver
import time
import os

# 数据初始化
browser = webdriver.Chrome()
# 绝对路径
file_path = os.path.dirname(__file__) + '/html/' + 'checkbox.html'
print os.path.dirname(__file__)
print file_path

# 打开浏览器
browser.get(file_path)
browser.maximize_window()

# 选择页面上所有的input，然后从中过滤出所有的checkbox并勾选之
inputs = browser.find_elements_by_tag_name('input')
for input_ in inputs:
    if input_.get_attribute('type') == 'checkbox':
        input_.click()
        time.sleep(2)

# 断言
no = 1
try:
    for input_ in inputs:
        if input_.get_attribute('type') == 'checkbox':
            assert input_.is_selected()
            print "第%s个测试ok" % no
            no += 1

finally:
    # 关闭浏览器
    browser.quit()
