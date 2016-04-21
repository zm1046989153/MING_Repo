#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 22
"""

# 入门ui练习
# http://www.cnblogs.com/zhangfei/p/3158223.html

from selenium import webdriver
import time
import os
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait


# 数据初始化
browser = webdriver.Chrome()
file_path = os.path.dirname(__file__) + '/html/' + 'demo.html'

# 打开浏览器
browser.get(file_path)

# 定位input
elem_1 = browser.find_element_by_id("user")
elem_1.send_keys("hello")
time.sleep(1)
elem_1.clear()
time.sleep(1)
elem_1.send_keys("hello")
print elem_1.get_attribute("value")
time.sleep(3)

# 定位link
elem_2 = browser.find_element_by_class_name("baidu")
href_2 = elem_2.get_attribute("href")
text_2 = elem_2.text
elem_2.click()
time.sleep(2)
browser.back()
time.sleep(3)

# 定位select
elem_3 = browser.find_element_by_name("select")
elem_3.click()
time.sleep(2)
elem_3_2 = browser.find_element_by_css_selector("select > option[value='opel']")
elem_3_2.click()
print elem_3.get_attribute("value")
time.sleep(3)

# radio
elem_4 = browser.find_element_by_css_selector("#radio > input.Opel")
elem_4.click()
print elem_4.is_selected()

# checkbox
elem_5 = browser.find_element_by_css_selector("#checkbox > input[name='checkbox3']")
elem_5.click()
print elem_5.is_selected()

# button
element_6 = browser.find_element_by_css_selector("input.button")
element_6.click()
print element_6.is_enabled()

# alert
element_7 = browser.find_element_by_css_selector("#alert > input")
element_7.click()
time.sleep(2)
browser.switch_to.alert.accept()

# upload
element_8 = browser.find_element_by_css_selector("#upload > #load")
element_8.send_keys(file_path)

# javascript
javascript_1 = "scrollTo(0, 10000)"
browser.execute_script(javascript_1)
time.sleep(3)

# new window tab
time.sleep(3)
element_9 = browser.find_element_by_link_text("Open new window")
element_9.click()
time.sleep(3)
handle_9_all = browser.window_handles
# 切换到窗口2
browser.switch_to.window(handle_9_all[1])
browser.close()
# 切换到窗口1
browser.switch_to.window(handle_9_all[0])

# action
element_10 = browser.find_element_by_css_selector("input.over")
ActionChains(browser).move_to_element(element_10).perform()
time.sleep(3)
print browser.find_element_by_id("over").text

#wait
element_11 = browser.find_element_by_css_selector("input.wait")
element_11.click()
WebDriverWait(browser, 300).until(lambda elem: browser.find_element_by_css_selector("div.red").is_displayed())
print browser.find_element_by_css_selector("div.red").text

# 退出浏览器
browser.close()

