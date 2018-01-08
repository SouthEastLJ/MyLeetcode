#!/usr/bin/env python3
# -*- coding: utf-8 -*-



#问题描述
#Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines 
#are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
#forms a container, such that the container contains the most water.

#Note: You may not slant the container and n is at least 2.



class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxh=0
        i=0
        j=len(height)-1
        
        while i<j :
            maxh = max(maxh,(j-i)*min(height[i],height[j]))
            if(height[i]<height[j]):
                i=i+1
            else:
                j=j-1
                
        return maxh
		
a=Solution()
heig=[1,2,3,4,2,1]
print(a.maxArea(heig))