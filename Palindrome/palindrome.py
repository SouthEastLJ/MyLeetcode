#!/usr/bin/env python3
# -*- coding: utf-8 -*-



#不使用额外的空间

class Solution(object):
	def isPalindrome(self, x):
		if x < 0:
			return False
		else:
			return x == int(str(x)[::-1])
			
x=Solution()
print(x.isPalindrome(1233211))