#coding: utf-8

"""
@Author: Well
@Date: 2014 - 04 - 16
"""

import userinfo
import csv
import os

# 通过dict获取账号信息


def read_dict():
    data = userinfo.admin_passport()
    for k, v in data.items():
        print k
        print v


# 通过list获取账号信息
def read_list():
    data = userinfo.user_passport()
    print data[0].split(',')[0]
    print data[0].split(',')[1]


# 从.txt文件中读取信息(相对路径)
def read_txt():

    source = file(os.path.pardir + "\data\username.txt", "r")
    test_username = source.read()
    source2 = file(os.path.pardir + "\data\password.txt", "r")
    test_password = source2.read()

    source.close()
    source2.close()
    print test_username, test_password


# 从csv文件中读取信息（相对路径）
def read_csv():

    my_file = os.path.pardir + '\data\userinfo.csv'
    data = csv.reader(file(my_file, 'rb'))
    for user_list in data:
        for user in user_list:
            print user

read_dict()
read_list()
read_txt()
read_csv()

