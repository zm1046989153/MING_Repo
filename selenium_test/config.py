#!/usr/bin/env python
# coding: utf-8

"""
@Author: Well
@Date: 2014 - 06 - 30
"""


def get_config():
    d = {'http://192.168.125.11:5555/wd/hub': 'chrome',
         'http://192.168.125.3:5555/wd/hub': 'firefox'

    }

    print "Success read computer and browser!"

    return d