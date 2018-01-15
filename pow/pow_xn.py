
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

class Solution:
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        ans = 1
        buf = x
        if n == 0:
            return 1
        elif n<0:
            n=int (-1*n)
            buf=1/buf
        while n:
            if int (n)%2 ==1:
                ans =ans*buf
            buf = buf*buf
            n = int (n/2)
        return ans
		
a=Solution()

print(a.myPow(2,10))