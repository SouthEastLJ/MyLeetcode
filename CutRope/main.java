
/*
 * 思想：动态规划
 * 考虑绳子长度为4
 * 有2种方案：1 3   2 2
 * 考虑绳子长度为5
 * 有方案：1 4  2 3  上述方案中的4怎么得到最大呢。那么长度为5的绳子怎么剪包含长度为4的绳子怎么剪这个子问题。
 * 依次类推：长度为6  1 5 2 4  3 3   这个方案包含子问题（长度为5 4 3 的绳子怎么剪）
 * 
 * 解法：先解决子问题，用子问题的结果去解决问题。这十分符合编程思想。
 */




class solution{ 
	int MaxSolution(int length)
	{
		
		if(length<=1)
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;
		int []out = new int[length+1];
		out[0]=0;
		out[1]=1;
		out[2]=2;
		out[3]=3;
		int max=0;
		for(int i=4;i<=length;i++)
		{
			max=0;
			for(int j=1;j<=i/2;j++)
			{
				int offer = out[j]*out[i-j];
				if(offer>max)
					max=offer;
				out[i]=max;
			}
		}
		max=out[length];
		return max;
		
	}
}
public class main {
	public static void main(String []args) {
		int length = 8;
		System.out.print(new solution().MaxSolution(length));
	}
}
