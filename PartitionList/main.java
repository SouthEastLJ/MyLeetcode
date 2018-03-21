package partition;

import java.util.*;

class ListNode{
    ListNode next;
    int val;
    ListNode(int x){
        val=x;
    }
}

class solution{
    public ListNode partition(ListNode head , int x){
        if(head ==null) return head;
        ListNode a1 = new ListNode(0);

        ListNode a2 = new ListNode(0);
        ListNode b1 = a1;
        ListNode b2 = a2;
        ListNode cur = head;
        while(cur!=null)
        {
            if (cur.val<x)
            {
                b1.next = new ListNode(cur.val);
                b1=b1.next;
            }
            else
            {
                b2.next = new ListNode(cur.val);
                b2=b2.next;
            }
            cur = cur.next;
        }
        b1.next = a2.next;
        return a1.next;

    }
}
public class main {
    public static ListNode stringToListNode(int [] input) {
        // Generate array from the input
        //int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : input) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    public static void main(String []args)
    {
        int [] in ={1,4,3,2,5,2};
        int target = 3;
        ListNode input = stringToListNode(in);
        ListNode out = new solution().partition(input,target);
        String answer = listNodeToString(out);
        System.out.print(answer);
    }


}
