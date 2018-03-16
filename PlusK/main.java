package leetcode66;

import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits,int k) {
    	
    	int n = digits.length;
    	int []out = new int[n+1];
    	int []out2 = new int[n];
    	
    	out[n] = (digits[n-1]+k)%10;
    	int flag =(digits[n-1]+k)/10;
    	for (int i = n-2;i>=0;i--)
    	{	
    		out[i+1]=(digits[i]+flag)%10;
			flag =(digits[i]+flag)/10;
			
		
    	}
    	out[0]=flag;
    	if(flag == 0)
    	{
    		for(int i=1;i<n+1;i++)
    		{
    			out2[i-1]=out[i];
    		}
    		return out2;
    	}
    	else
    		return out;
        
    }
}

public class main {
	public static void main(String []args)
	{
		int []a= {9,9,9,9};
		int []out = new int[a.length+1];
		out = new Solution().plusOne(a,32); 
		System.out.println(Arrays.toString(out));
	}

}
