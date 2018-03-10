package leetcode83;



// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 
class Solution {
	
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode now = head;


        while( now!=null && now.next!=null  )
	    {
	        if(now.val==now.next.val)
	        {
	        	now.next=now.next.next; //有这句话，所以要加上now.next!=null
	        }
	        else
	        {
	        	now  = now.next;
	        }
        }       
        return head;        
    }
}
//public class main {
//    public static String listNodeToString(ListNode node) {
//        if (node == null) {
//            return "[]";
//        }
//    
//        String result = "";
//        while (node != null) {
//            result += Integer.toString(node.val) + ", ";
//            node = node.next;
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//    
//	public static void main(String []args )
//	{
//        int[] nodeValues = {1,1,2,2,3,3,3,6};
//        
//        // Now convert that list into linked list
//        ListNode dummyRoot = new ListNode(0);
//        ListNode ptr = dummyRoot;
//        for(int item : nodeValues) {
//            ptr.next = new ListNode(item);
//            ptr = ptr.next;
//        }
//        
//        ListNode ret = new Solution().deleteDuplicates(dummyRoot.next);
//        
//        String out = listNodeToString(ret);
//        
//        System.out.print(out);
//
//	}
//
//}




public class main {
	public static void main(String []args )
	{
		ListNode head = new ListNode(1);
		ListNode pro = head;
		pro.next = new ListNode(1);
		pro=pro.next;
		pro.next = new ListNode(3);

		Solution a =new Solution();
//		ListNode out=head;
		ListNode out = a.deleteDuplicates(head);
		while( out!=null  )
		{
			System.out.println(out.val);
			
			out=out.next;
		}
	}

}
