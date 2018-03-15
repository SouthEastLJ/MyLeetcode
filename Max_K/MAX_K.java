package max_K;

public class MAX_K {
	
    public static void main(String[] args) { 
    	//只要类存在，static变量就存在。
    	//非static修饰的成员变量是在对象new出来的时候划分存储空间，是与具体的对象绑定的，
    	//该成员变量仅为当前对象所拥有的。
        int[] a = {1,4,7,8,9};  
        int ans = new MAX_K().find(a,2);  
        System.out.println("ans: "+ans);  
    } 
    
    
	public int find(int []arrays,int k)
	{
		int index = 0;
		int l =0;
		int n = arrays.length-1;
		while(index!=k)
		{
			index = quick_sort(arrays,l,n);
			if(index<k)
				l=index+1;
			else if(index>k)
				n=index-1;
		}
		return arrays[index];
	}
	
	
	
	
	public  int quick_sort(int []arrays,int l,int r) 
	{
		if(l<r)
		{
			int i=l;
			int j=r;
			int temp = arrays[i];
			while(i<j)
			{
				while(i<j&&arrays[j]>=temp)
					j--;
				arrays[i]=arrays[j];
				while(i<j&&arrays[i]<=temp)
					i++;
				arrays[j]=arrays[i];
			}
			arrays[i]=temp;
			return i;
		}
		return -1;
	}
	
	


}
