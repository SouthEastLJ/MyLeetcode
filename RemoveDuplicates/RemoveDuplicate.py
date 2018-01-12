#!/usr/bin/env python3
# -*- coding: utf-8 -*-


#要求
#Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
#Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        k=0
        if len(nums)==0:               #注意，一定要加保护
            return 0
        for i in range(len(nums)-1):
            j=i+1
            if nums[k]!=nums[j]:
                k=k+1
                nums[k]=nums[j]             
        return nums[0:k+1]
		
a=Solution()

c=[1,3,4,4,6,7,7,8]
print(a.removeDuplicates(c))