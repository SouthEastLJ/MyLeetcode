
/*
 * ˼�룺��̬�滮
 * �������ӳ���Ϊ4
 * ��2�ַ�����1 3   2 2
 * �������ӳ���Ϊ5
 * �з�����1 4  2 3  ���������е�4��ô�õ�����ء���ô����Ϊ5��������ô����������Ϊ4��������ô����������⡣
 * �������ƣ�����Ϊ6  1 5 2 4  3 3   ����������������⣨����Ϊ5 4 3 ��������ô����
 * 
 * �ⷨ���Ƚ�������⣬��������Ľ��ȥ������⡣��ʮ�ַ��ϱ��˼�롣
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
