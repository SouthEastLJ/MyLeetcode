package tengxun3;

import java.util.Arrays;
import java.util.Scanner;

public class main{
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner in = new Scanner (System.in); 
        int num = in.nextInt();

        int [][]st=new int[num][4];
        int [][]yt=new int[num][4];
        int []comp = new int[6];
        int j = 0;
        for(int i=0;i<num;i++)
        {
        	for(j=0;j<4;j++)
        	{
        		st[i][j] = in.nextInt();  // n为数
        	}
        	for(j=0;j<4;j++)
        	{
        		yt[i][j] = in.nextInt();  // n为数
        	}
        }
        for(int i=0;i<num;i++)
        {
        	comp[0] = (st[i][0]-st[i][1])*(st[i][0]-st[i][1])+(yt[i][0]-yt[i][1])*(yt[i][0]-yt[i][1]);
        	comp[1] = (st[i][1]-st[i][3])*(st[i][1]-st[i][3])+(yt[i][1]-yt[i][3])*(yt[i][1]-yt[i][3]);
        	comp[2] = (st[i][2]-st[i][3])*(st[i][2]-st[i][3])+(yt[i][2]-yt[i][3])*(yt[i][2]-yt[i][3]);
        	comp[3] = (st[i][0]-st[i][2])*(st[i][0]-st[i][2])+(yt[i][0]-yt[i][2])*(yt[i][0]-yt[i][2]);
        	comp[4] = (st[i][0]-st[i][3])*(st[i][0]-st[i][3])+(yt[i][0]-yt[i][3])*(yt[i][0]-yt[i][3]);
        	comp[5] = (st[i][1]-st[i][2])*(st[i][1]-st[i][2])+(yt[i][1]-yt[i][2])*(yt[i][1]-yt[i][2]);
        	Arrays.sort(comp);
        	if(comp[0]==comp[1] && comp[0]==comp[2]&& comp[0]==comp[3] && comp[4]==comp[5] && comp[0]!=comp[4])
        	{
        		System.out.println("Yes");
        	}
        	else
        	{
        		System.out.println("No");

        	}
        }            
    }
}