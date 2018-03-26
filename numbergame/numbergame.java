package wangyi_numbergame;

/*С����������һ��������Ϸ��С�׸���һϵ�е�������������ʹ����Щ��������Ϸ��
 * ÿ��С�׻�����˵һ�����ֳ�����Ȼ������Ҫ����һϵ��������ѡȡһ���ֳ�����
 * ���ǵĺ͵���С����˵�����֡� ���磺 ���{2,1,2,7}�����е�һϵ������С��˵��������11.
 * ����Եõ�����2+2+7 = 11.�����Ƥ��С������㣬��˵��������6����ô��û�а취ƴ�ճ���Ϊ6 
 * ����С�׸���n�����������ҳ��޷���n������ѡȡ������͵������е���С����
 * 
 * ���룺
 * 3
 * 5 1 2
 * �����
 * 4
 * 
 */

import java.util.*;

public class numbergame {
	  public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
		  
	      //Queue<Integer> Q = new ArrayDeque<>();
	      int T = scan.nextInt();
	      long []array = new long[T];
	      for (int TC = 0; TC < T; TC++) {
	    	  array[TC] = scan.nextInt();
	      }
	      scan.close();
	      Arrays.sort(array);
	      
	      long N = 0;
	      long add = array[0];
	      int i=0;
	      int flag =0;
	      while(i<T-1 )
	      {
	    	     	  
	    	  if(add>N+1)
	    	  {
	    		  flag=1;
	    		  break;
	    	  }
    	   	  N=N+array[i]; 
	    	  add = array[i+1];
	    	  if(add>N+1)
	    	  {
	    		  flag=1;
	    		  break;
	    	  }
	    	  i++;
	 
	      }

	      if(flag == 1)
	    	  System.out.printf("%d\n", N+1);
	      
    	  else
	    	  System.out.printf("%d\n", N+array[i]+1);
	  }
	
}

/*�ȸ������
 * Input��
 *The first line of the input gives the number of test cases, T. T test cases follow. 
 *Each consists of one line with three space-separated values C, D, and V, followed by another 
 *line with D distinct space-separated values representing the preexisting denominations, in ascending order.
 * Output��
 *For each test case, output one line containing "Case #x: y", where x is the test case number 
 *(starting from 1) and y is the minimum number of new denominations required, as described above.
 *example��
 * 4
1 2 3
1 2
1 3 6
1 2 5
2 1 3
3
1 6 100
1 5 10 25 50 100

Case #1: 0
Case #2: 1
Case #3: 1
Case #4: 3

 * 
 */


//public class numbergame {
//  public static void main(String[] args) {
//    Scanner scan = new Scanner(System.in);
//    int T = scan.nextInt();
//    for (int TC = 1; TC <= T; TC++) {
//      int C = scan.nextInt();
//      int D = scan.nextInt();
//      int V = scan.nextInt();
//      Queue<Integer> Q = new ArrayDeque<>();
//      for (int i = 0; i < D; i++) {
//        Q.add(scan.nextInt());
//      }
//
//      long N = 0;
//      int add = 0;
//      while (N < V) {
//        // X = The smallest value we cannot produce.
//        long X = N + 1;
//        if (!Q.isEmpty() && Q.peek() <= X) {
//          // Use pre-existing denomination we haven't used.
//          X = Q.poll();
//          
//        } else {
//          // No way to produce N+1, add a new denomination.
//          add++;
//        }
//        N += X * C;
//      }
//      System.out.printf("Case #%d: %d\n", TC, add);
//    }
//  }
//}