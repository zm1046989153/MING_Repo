#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 20
"""

# 9 层级定位

from selenium import webdriver
import os
import time
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait

# 数据初始化
browser = webdriver.Chrome()
base_url = os.path.dirname(__file__) + '/html/' + 'level_locate.html'

# 打开浏览器
browser.get(base_url)
browser.maximize_window()

# 点击Link2链接
browser.find_element_by_link_text('Link1').click()
time.sleep(5)

WebDriverWait(browser, 10).until(lambda browser_: browser.find_element_by_id('dropdown1').is_displayed())
# 在父元素下找到子元素
menu = browser.find_element_by_id('dropdown1').find_element_by_link_text('Action')
ActionChains(browser).move_to_element(menu).perform()
time.sleep(5)

# 关闭浏览器
browser.quit()