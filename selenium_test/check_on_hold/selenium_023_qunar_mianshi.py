#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 30
"""

# http://www.cnblogs.com/nbkhic/p/3657035.html

from selenium import webdriver
import time


base_url = "http://flight.qunar.com/"
data_7 = time.strftime("%Y-%m-%d", time.localtime(time.time()))
print data_7

browser = webdriver.Chrome()
browser.get(base_url)

# 选择”单程“
browser.find_element_by_css_selector("input#searchTypeSng").click()
time.sleep(2)
browser.find_element_by_css_selector('#dfsForm > div.crl_sp_city > div:nth-child(5) > div > input').send_keys(u'北京')
time.sleep(2)
browser.find_element_by_css_selector("#dom_arrivalDateDiv > div > input").click()
time.sleep(2)
browser.find_element_by_css_selector("#dom_arrivalDateDiv > div > input").send_keys(data_7)
time.sleep(2)
browser.find_element_by_css_selector("button.btn_txt[data-track*='国内搜索']").click()
time.sleep(15)




