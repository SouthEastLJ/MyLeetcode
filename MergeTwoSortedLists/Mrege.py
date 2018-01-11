#!/usr/bin/env python3
# -*- coding: utf-8 -*-

#问题描述
#Input: 1->2->4, 1->3->4
#Output: 1->1->2->3->4->4
import math

class Solution:
	def mergeTwoLists(self, l1, l2):
		cur = [None]*(len(l1)+len(l2))
		i=0
		j=0
		k=0
		while i<len(l1) and j<len(l2):
			if l1[i] < l2[j]:
				cur[k] = l1[i]
				i=i+1
			else:
				cur[k] = l2[j]
				j=j+1
			k=k+1
		if i<len(l1):
			cur[k:k+len(l1)-i] = l1[i:len(l1)]
		elif j<len(l2):
			cur[k:k+len(l2)-j] = l2[j:len(l2)]
		return cur
			
			
		
a=Solution()
b=[1,2,4,5]
c=[1,3,4,4,6,7,7,8]
print(a.mergeTwoLists(b,c))


# Definition for singly-linked list.

#也可以使用列表的思想来做
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy = cur = ListNode(0)
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next  
        cur.next = l1 or l2
        return dummy.next       

'''
# iteratively
def mergeTwoLists1(self, l1, l2):
    dummy = cur = ListNode(0)
    while l1 and l2:
        if l1.val < l2.val:
            cur.next = l1
            l1 = l1.next
        else:
            cur.next = l2
            l2 = l2.next
        cur = cur.next
    cur.next = l1 or l2
    return dummy.next
    
# recursively    
def mergeTwoLists2(self, l1, l2):
    if not l1 or not l2:
        return l1 or l2
    if l1.val < l2.val:
        l1.next = self.mergeTwoLists(l1.next, l2)
        return l1
    else:
        l2.next = self.mergeTwoLists(l1, l2.next)
        return l2
        
# in-place, iteratively        
def mergeTwoLists(self, l1, l2):
    if None in (l1, l2):
        return l1 or l2
    dummy = cur = ListNode(0)
    dummy.next = l1
    while l1 and l2:
        if l1.val < l2.val:
            l1 = l1.next
        else:
            nxt = cur.next
            cur.next = l2
            tmp = l2.next
            l2.next = nxt
            l2 = tmp
        cur = cur.next
    cur.next = l1 or l2
    return dummy.next
	
	
	
If both lists are non-empty, I first make sure a starts smaller, use its head as result, and merge the remainders behind it. Otherwise, i.e., if one or both are empty, I just return what’s there.
class Solution:
    def mergeTwoLists(self, a, b):
        if a and b:
            if a.val > b.val:
                a, b = b, a
            a.next = self.mergeTwoLists(a.next, b)
        return a or b
Solution 2

First make sure that a is the “better” one (meaning b is None or has larger/equal value). Then merge the remainders behind a.

def mergeTwoLists(self, a, b):
    if not a or b and a.val > b.val:
        a, b = b, a
    if a:
        a.next = self.mergeTwoLists(a.next, b)
    return a
'''

