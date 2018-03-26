package leetcode_45;

import java.util.Scanner;


/*
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Note:You can assume that you can always reach the last index.
 */
public class jump {
	
    public static int jump(int[] nums) {
    	if(nums.length<2)
    		return 0;
    	int currentMax=0,level=0,nextMax=0,i=0;
    	while(currentMax-i+1>0)
    	{
    		level++;
    		for(;i<=currentMax;i++)
    		{
    			
    			nextMax = Math.max(nextMax,nums[i]+i);
    			if(nextMax>=nums.length-1)
    				return level;
    		}
    		currentMax = nextMax;
    	}
    	return 0;
        
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();
    	
    	int []num = new int[N];
    	for(int i=0;i<N;i++)
    	{
    		num[i]=scan.nextInt();
    	}
    	int out =jump(num);
    	System.out.println(out);
    }
}
