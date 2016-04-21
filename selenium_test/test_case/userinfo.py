#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 16
"""
import collections

def admin_passport():
    # dict 格式存储
    data = collections.OrderedDict()
    data['admin'] = 'admin'
    print "success read username and password from admin_passport()"
    return data

def user_passport():
    # list 格式存储
    data = ['user001,user001', 'user002,user002']
    print "success read username and password from user_passport()"
    return data
