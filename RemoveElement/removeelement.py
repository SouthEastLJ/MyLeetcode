
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

#remove方法没有返回值
#善于使用remove count这两个方法。
class Solution:
	def removeElement(self, nums, val):
		n=0
		for i in range(nums.count(val)):
			nums.remove(val)
		return nums
		
a=Solution()

c=[1,3,4,4,6,7,7,8]
print(a.removeElement(c,4))