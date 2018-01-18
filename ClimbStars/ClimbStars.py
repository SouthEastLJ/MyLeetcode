#!/usr/bin/env python3
# -*- coding: utf-8 -*-

#Input: 3
#Output:  3
#Explanation:  There are three ways to climb to the top.

#1. 1 step + 1 step + 1 step
#2. 1 step + 2 steps
#3. 2 steps + 1 step

class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n==1:
            return 1
        elif n==0:
            return 1
        else:
            return self.climbStairs(n-1)+self.climbStairs(n-2)##记得加self.
			
			
			
a=Solution()

print(a.climbStairs(35))
		