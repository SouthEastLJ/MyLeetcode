#!/usr/bin/env python3
# -*- coding: utf-8 -*-

class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        dict={'}':'{',']':'[',')':'('}
        out=[]
        for i in s:
            if i in dict.values():
                out.append(i)
            elif i in dict.keys():
                if len(out)==0 or dict[i]!=out.pop():
                    return False
            else:
                return False
        return len(out)==0