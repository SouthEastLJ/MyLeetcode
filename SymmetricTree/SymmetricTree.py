#!/usr/bin/env python3
# -*- coding: utf-8 -*-

#Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

#For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

#But the following [1,2,2,null,3,null,3] is not:



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        q=[]
        q.append(root)
        q.append(root)
        while len(q)!=0 :
            t1 = q.pop()
            t2 = q.pop()
            if t1==None and t2==None:
                continue
            if t1==None or t2==None:
                return False
            if t1.val != t2.val:
                return False
            q.append(t1.left)
            q.append(t2.right)
            q.append(t1.right)
            q.append(t2.left)
            
        return True
		
tree = TreeNode(1)
tree1 = TreeNode(2)
tree2 = TreeNode(2)
tree.left = tree1
tree.right= tree2

a=Solution()
print(a.isSymmetric(tree))
