#!/usr/bin/python3
# Filename: using_sys.py

import sys

print('命令行参数如下:')
for i in sys.argv:
	print(i)

print('/n/nThe PYTHONPATH is', sys.path, '/n')
