#!/usr/bin/env python3
# -*- coding: utf-8 -*-


class Solution:
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m = len(grid) #行数
        n = len(grid[0])
        for i in range(0,m):
            for j in range(0,n):
                if i==0 and j!=0 :
                    grid[i][j]+=grid[i][j-1]
                elif j==0 and i!=0 :
                    grid[i][j]+=grid[i-1][j]
                elif i==0 and j==0:
                    grid[i][j]=grid[i][j]
                else:
                    grid[i][j]+=min(grid[i-1][j],grid[i][j-1])
        return grid[-1][-1]
		
a=Solution()
L=[[1,3,1],[1,5,1],[4,2,1]]
print(a.minPathSum(L))