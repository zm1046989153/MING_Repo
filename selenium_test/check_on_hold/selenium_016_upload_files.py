#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 12
"""

# 16 上传文件


from selenium import webdriver
import time
import os.path

# 数据初始化
browser = webdriver.Chrome()
base_url = "http://anonymousdelivers.us/"
file_path = os.path.dirname(__file__) + '/html/' + 'test.txt'
file_path_real = file_path.replace('/', '\\')
print file_path
print file_path_real


# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 勾选Private link
browser.find_element_by_id('private').click()
time.sleep(2)
# 定位”浏览“按钮
browser.find_element_by_name("userfile").send_keys(file_path_real)
time.sleep(3)

# 上传成功
if browser.current_url != base_url:
    print "上传成功"
    time.sleep(3)

# 退出浏览器
browser.quit()









