#!/usr/bin/env python3
# -*- coding: utf-8 -*-


#Definition for singly-linked list.
#检查一个链表是否为循环列表
#主要有两种算法
#1：哈希表
#2：设置两个指针 一个快 一个慢，看他们能否最后相遇，能，证明是循环列表，不能，证明不是循环列表

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow = head
        if slow == None:
            return False
        faster=head.next
        while slow != faster :
            if slow==None or faster ==None :
                return False
            if slow.next != None:
                slow = slow.next
            else:
                return False
            if faster.next!=None:
                faster=faster.next.next
            else:
                return False
        return True
		
a=ListNode(1)

b=ListNode(2)
a.next = b

c=ListNode(3)
b.next = c

#c.next = b

test = Solution()

print(test.hasCycle(a))