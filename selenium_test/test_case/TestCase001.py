  #coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 15
"""
# http://www.tudou.com/listplay/09WXqH9MAwc/TduHyklnOpY.html

import unittest
from selenium import webdriver
import time
import login
import os


# 用admin账号，登录网站，可以登录成功

class MyTestCase(unittest.TestCase):

    def setUp(self):
        print "start test", time.strftime("%Y:%m:%d:%H:%M:%S", time.localtime(time.time()))
        # 浏览器初始化
        self.browser = webdriver.Chrome()
        self.browser.maximize_window()
        # 主页地址
        self.base_url = 'http://127.0.0.1/wordpress/'
        # 从data文件夹下的文本读取信息(相对路径)
        source = file(r"C:\Users\wei\Documents\GitHub\neilpytest\selenium_test\data\username.txt", "r")
        source2 = file(r"C:\Users\wei\Documents\GitHub\neilpytest\selenium_test\data\password.txt", "r")
        self.test_username = source.read()
        self.test_password = source2.read()
        source.close()
        source2.close()

    def tearDown(self):
        self.browser.quit()
        print "finish test"

    def test_login(self):
        print "open browser"

        # 打开wordpress首页
        self.browser.get(self.base_url)
        # 跳转登录页面
        self.browser.find_element_by_partial_link_text(u"登录").click()
        # 调用login()
        login.login(self, self.test_username, self.test_password)

        # 捕捉“断言”中的异常
        try:
            # 因该跳转到wp-admin页面
            self.assertTrue('wp-admin' in self.browser.current_url)
            #  页面右上角应该包含“登录用户名”
            greeting_link = self.browser.find_element_by_css_selector("#wp-admin-bar-my-account > a")
            self.assertTrue('admin' in greeting_link.text)

        finally:

            file_name = os.path.basename(__file__).split('.')[0]
            png_path = r'C:\Users\wei\Documents\GitHub\neilpytest\selenium_test\png'
            file_path = png_path + '\\' + file_name + '.png'
            # if os.path.exists(file_path):
            #     os.remove(file_path)
            #     print "remove"
            # 截图；原截图文件存在的话，get_screenshot_as_file（）会覆盖更新
            self.browser.get_screenshot_as_file(file_path)


if __name__ == '__main__':
    unittest.main()
