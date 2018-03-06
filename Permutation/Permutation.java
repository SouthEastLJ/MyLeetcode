package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





class solution
{
	public void nextPermutation(int[] nums)
	{
		int i =nums.length -2;
		int j =0;
		while(i>=0)
		{
			if (nums[i]<nums[i+1]) break;
			i--;
		}
		if(i>=0)
		{
			for(j = nums.length-1;j>=0;j--)
			{
				if(nums[j]>nums[i])
					break;
			}
			swap(nums,i,j);
		}
		reverse(nums,i+1);
	}
	private void swap(int[]nums,int i,int j)
	{
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	private void reverse(int []nums,int i)
	{
		int j=nums.length - 1;
		while(i<j)
		{
			swap(nums,i,j);
			i++;
			j--;
		}
	}
}
public class Permutation {
	  public static void main(String args[])
	  {
		  solution a = new solution();
		  //int []nums= {1,5,8,4,7,6,5,3,1}; 
		  int []nums= {1,5,8,5,1,3,4,6,7};
		  a.nextPermutation(nums);
		  for(int i =0;i<nums.length;i++) 
		  {
			  System.out.print(nums[i]);

		  }
	  }
	}