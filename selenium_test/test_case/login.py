#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 16
"""
import time


def login(self, username, password):
    browser = self.browser
    # 输入用户名
    browser.find_element_by_id('user_login').send_keys(username)
    # 输入密码
    browser.find_element_by_id('user_pass').send_keys(password)
    # 点击登录按钮
    browser.find_element_by_id('wp-submit').click()
    # 等待几秒进行加载
    time.sleep(5)