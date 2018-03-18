package wangyi_huiwen;


import java.util.Scanner;
 
public class test{
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner in = new Scanner (System.in); 
        String a = in.nextLine();
        String b = in.nextLine();
        int count = 0;
        StringBuffer s = new StringBuffer(a);
        for(int i=0;i<s.length();i++){
            StringBuffer temp = new StringBuffer(s);
            temp.insert(i,b);
            if(isF(temp)){
                count ++;
            }
        }
        if(isF(s.append(b))){
            count ++;
        }
        System.out.println(count);
    }
    public static boolean isF(StringBuffer sb){
        StringBuffer temp = new StringBuffer(sb);
        StringBuffer re = temp.reverse();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) != re.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
