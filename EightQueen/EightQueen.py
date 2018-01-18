#!/usr/bin/env python3
# -*- coding: utf-8 -*-




#class Solution(object):
def conflict (state,nextX):   #冲突检查
	nextY = len(state)
	for i in range(nextY):
		if(abs(state[i]-nextX) in (0,nextY-i)):
			return True
	return False
#采用生成器的方式来产生每一个皇后的位置，用递归来实现下一个皇后的位置	
def queens( num,state=() ):
	for pos in range(num):
		if  not conflict(state,pos):
			if len(state) == num-1:
				yield (pos,)
			else:
				for result in queens(num,state+(pos,)): #将当前皇后的信息添加到状态列表，并传递给下一个皇后
					yield (pos,)+result
						
	
#a=Solution()
for i in list(queens(8)):
	print(i)
	
print(len(list(queens(8))))


