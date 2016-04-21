#!/usr/bin/env python
# coding: utf-8

"""
@Author: Well
@Date: 2014 - 06 - 30
"""

import unittest
from time import sleep
from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
import config


class MyTestCase(unittest.TestCase):
    def setUp(self):
        print "start test "
        self.base_url = 'http://www.baidu.com'

    def tearDown(self):
        self.browser.quit()
        print "finish test"

    def test_baidu(self):
        # 通过host， browser 来参数化脚本
        for host, browser_ in config.get_config().items():
            print host
            print browser_
            self.browser = webdriver.Remote(
                command_executor=host,
                desired_capabilities={
                    "browserName": browser_,
                    "version": "",
                    "platform": "ANY",
                    "javascriptEnabled": True

                })

            print "open browser"
            self.browser.get(self.base_url)
            self.browser.maximize_window()
            self.browser.find_element_by_id("kw1").send_keys("selenium")
            self.browser.find_element_by_id("su1").click()
            sleep(3)
            self.browser.refresh()
            sleep(3)

            try:
                title = self.browser.title
                self.assertTrue(u'selenium_百度搜索' in title)

            finally:
                self.browser.get_screenshot_as_file('png\\test001.png')


if __name__ == '__main__':
    unittest.main()