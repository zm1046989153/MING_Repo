#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 18
"""

# 测试例子
import unittest
from selenium import webdriver
import time


class MyTestCase(unittest.TestCase):
    def setUp(self):
        print "start test "
        self.base_url = 'http://www.baidu.com'
        self.browser = webdriver.Chrome()

    def tearDown(self):
        self.browser.quit()
        print "finish test"

    def test_baidu(self):
        print "open browser"
        self.browser.get(self.base_url)
        self.browser.maximize_window()
        self.browser.find_element_by_id("kw1").send_keys("selenium")
        self.browser.find_element_by_id("su1").click()
        time.sleep(3)
        self.browser.refresh()
        time.sleep(3)

        try:
            title = self.browser.title
            self.assertTrue(u'selenium_百度搜索' in title)

        finally:
            self.browser.get_screenshot_as_file('png\\test001.png')


if __name__ == '__main__':
    unittest.main()
