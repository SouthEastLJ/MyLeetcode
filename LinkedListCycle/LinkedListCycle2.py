#!/usr/bin/env python3
# -*- coding: utf-8 -*-


#Definition for singly-linked list.
#检查一个链表是否为循环列表
#主要有两种算法
#1：哈希表
#2：设置两个指针 一个快 一个慢，看他们能否最后相遇，能，证明是循环列表，不能，证明不是循环列表

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def findCycle(self,head):
        faster = head
        later = head
        while faster !=None and faster.next != None:
            later = later.next
            faster = faster.next.next
            if later == faster:
                return later
        return None
            
        
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None:
            return None
        meet = self.findCycle(head)
        if meet is None:
            return None
        else:
            while meet!=head:
                meet=meet.next
                head=head.next
            return meet
		
a=ListNode(1)

b=ListNode(2)
a.next = b

c=ListNode(3)
b.next = c

#c.next = b

test = Solution()

print(test.detectCycle(a))