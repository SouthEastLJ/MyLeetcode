import java.io.File;
import java.util.*;

public class ReadBlackBST <Key extends Comparable <Key> , Value>{
	
	//这儿使用了泛型
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	//节点的定义
	private class Node{
		Key key; //键
		Value val;//相关联的值
		Node left,right;
		int N;   //这棵树的总结点数
		boolean color;
		//private int size;
		Node(Key key,Value val,int N,boolean color)
		{
			this.key = key;
			this.val = val;
			this.N =N;
			this.color = color;

		}
	}
	
	private boolean isRed(Node x)
	{
		if(x==null)
			return false;
		return x.color==RED;
	}
	//求节点个数
	
    public int size() {
        return size(root);
    }
    
	private int size(Node x)
	{
		if(x==null) 
			return 0;
		else 
			return x.N;  
	}
	
	//左旋转
	Node rotateleft(Node h)
	{
		Node x= h.right;
		h.right = x.left ;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left)+size(h.right);
		return x;
	}
	//右旋转
	Node rotateright(Node h)
	{
		Node x= h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1+size(h.left)+size(h.right);
		return x;
	}
	//分解四节点
	void flipcolors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	//获取键-值对对应的值
	
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    // value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }
    
    
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            //delete(key);
            return;
        }

        root = put(root, key, val);
        root.color = BLACK;
        // assert check();
    }
    
    private Node put(Node h, Key key, Value val) { 
        if (h == null) return new Node(key, val, 1,RED);

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left  = put(h.left,  key, val); 
        else if (cmp > 0) h.right = put(h.right, key, val); 
        else              h.val   = val;

        // fix-up any right-leaning links
        if (isRed(h.right) && !isRed(h.left))      h = rotateleft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateright(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipcolors(h);
        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("D:\\JavaProject\\RedBlackTree\\src\\data_BST.txt"));
        ReadBlackBST<Integer, String> bst = new ReadBlackBST<Integer, String>();
        while (input.hasNext()) {
        	int key = input.nextInt();
        	String value = input.next();
        	
        	
        	bst.put(key, value);
        }
        
        
        System.out.println(bst.get(1));
        System.out.println(bst.get(2));
    }



}
