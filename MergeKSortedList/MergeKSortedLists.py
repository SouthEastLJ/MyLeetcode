#!/usr/bin/env python3
# -*- coding: utf-8 -*-






# Definition for singly-linked list.

#另外一种方案，不用queue，使用
"""
def mergeKLists(self, lists):
        
        #:type lists: List[ListNode]
        #:rtype: ListNode
        
        
        pre = cur = ListNode(0)
           
        heap = []
        for i in range(len(lists)):
            if lists[i]: 
                heapq.heappush(heap, (lists[i].val, i, lists[i]))
                
        while heap:
            node = heapq.heappop(heap)
            idx = node[1]
            cur.next = node[2]  
            cur = cur.next
            
            if cur.next:
                heapq.heappush(heap, (cur.next.val, idx, cur.next))

        return pre.next
"""





from queue import PriorityQueue
class ListNode:
	def __init__(self, x):
		self.val = x
		self.next = None

class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        q=PriorityQueue()
        p=head=ListNode(None)
        for idx,i in enumerate(lists):
            if i:
                q.put((i.val,idx,i))    #这儿使用了元组，堆结构会对元组的第一个元素进行比较，如果一致，则比较下一个。如果不添加
        while not q.empty():            #下标作为第二个元素（下标不会重复），堆结构会比较两个ListNide元素，这会产生错误。
            value,idx2,node=q.get()
            p.next = ListNode(value)
            p=p.next
            node = node.next
            if node:
                q.put((node.val,idx2,node))
        return head.next
		
a1 = ListNode(1)
a2 = ListNode(3)
a3 = ListNode(5)
a1.next=a2
a2.next=a3
a3.next = None

b1 = ListNode(2)
b2 = ListNode(3)
b3 = ListNode(4)
b1.next = b2
b2.next = b3
b3.next = None

a=Solution()
answer = a.mergeKLists([a1,b1])
while answer:
	print(answer.val)
	answer = answer.next




