#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 03
"""

# 鼠标事件
# context_click()
# double_click()
# drag_and_drop()
# move_to_element()
# click_and_hold()

from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
import time
from selenium.webdriver.common.keys import Keys

# 数据初始化
base_url = "http://www.youdao.com"
browser = webdriver.Chrome()

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 定位到搜索输入框
input_ = browser.find_element_by_id('query')
time.sleep(3)

# context_click()
ActionChains(browser).context_click(input_).perform()
ActionChains(browser).move_by_offset(0, 0).click().perform()
time.sleep(3)

# double_click()
input_.send_keys('hello selenium')
time.sleep(3)
# 双击应有全选文字效果
ActionChains(browser).double_click(input_).perform()
time.sleep(3)

# drag_and_drop()
# 找不到例子
# mouse_from = browser.find_element_by_tag_name('')
# mouse_to = browser.find_elements_by_css_selector('')
# ActionChains(browser).drag_and_drop(mouse_from, mouse_to).perform()
# time.sleep(3)

# move_to_element()
above = browser.find_element_by_partial_link_text(u'有道云笔记')
ActionChains(browser).move_to_element(above).perform()
time.sleep(3)

# click_and_hold()
# 找不到例子
# ActionChains(browser).click_and_hold("").perform()

# 浏览器退出
browser.quit()








