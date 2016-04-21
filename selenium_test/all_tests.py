#!/usr/bin/env python
#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 16
"""

import unittest
import os
import time
from common import HTMLTestRunner

test_path = 'C:\\Users\\wei\\Documents\\GitHub\\neilpytest\\selenium_test\\test_case'


def create_suite():
    test_unit = unittest.TestSuite()
    # 定义discover
    discover = unittest.defaultTestLoader.discover(test_path)

    # discover 方法筛选出来的用例，添加到测试套件里
    for test_suit in discover:
        for test_case in test_suit:
            test_unit.addTests(test_case)
            print test_unit
    return test_unit

# 返回所有用例
all_test_names = create_suite()
print all_test_names

# 创建 report 文件
now = time.strftime('%Y-%m-%d-%H_%M_%S', time.localtime(time.time()))
file_name = os.getcwd() + '\\report\\' + now + 'result.html'

fp = open(file_name, 'wb')

runner = HTMLTestRunner.HTMLTestRunner(
    stream=fp,
    title=u'测试报告',
    description=u'用例执行情况'
)

# 执行所有的测试用例
runner.run(all_test_names)
