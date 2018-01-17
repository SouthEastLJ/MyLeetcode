
#!/usr/bin/env python3
# -*- coding: utf-8 -*-


#前提：All inputs will be in lower-case.

import collections 
class Solution:
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        ans=collections.defaultdict(list)
        for s in strs:
            ans[tuple(sorted(s))].append(s)
        return list(ans.values())
		
		
a=Solution()
L=["eat","eta","tea","tan","nat","bat"]
print(a.groupAnagrams(L))