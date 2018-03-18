package wangyi_queue;

import java.util.*;


class ListNode {
    int val;
    ListNode next;	
    ListNode(int x) { val = x; }
}
public class Main{
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner in = new Scanner (System.in); 
        int num = in.nextInt();
//        in.nextLine();
        int []st=new int[num];
        for(int i=0;i<num;i++)
        {
        	st[i] = in.nextInt();  // n为数
//        	in.nextLine();
        }
//        System.out.println(num+"test");
        for(int i=0;i<num;i++)
        {
        	//System.out.println(st[i]);
        	//in.nextLine();
        	int n=st[i];
        	int []out=new int[n];  //结果
			ListNode Root = new ListNode(0);
			ListNode ptr = Root;
			for(int ite=1; ite<n;ite++) {
				ptr.next = new ListNode(ite);
				ptr = ptr.next;
		    }
			ptr.next=Root;   //构造循环列表  Root = ptr.next   不对
			ListNode cur = Root;
			
			//System.out.println(ptr.next.val);
			//ptr = cur.next;
			
			int k =0;
			for(k = 0;k<n;k++)
//				while(cur!=null && cur.next!=null)
			{
				out[cur.next.val]=k+1;
				cur.next = cur.next.next;
				
				cur = cur.next;		
				
			}
			for(k=0;k<n;k++)
			{
				if(k==n-1)
					System.out.print(out[k]);
				else
					System.out.print(out[k]+" ");
				
			}
			System.out.println();
//       	    System.out.println(Arrays.toString(out));
//       	    System.out.println("hhhh");
        }
        
    }
}

