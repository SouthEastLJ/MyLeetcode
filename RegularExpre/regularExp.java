package regularExpress;


//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
// 
//public class regularExp
//{
//    public static void main( String args[] ){
// 
//      // ��ָ��ģʽ���ַ�������
//      String line = "This order was placed for QT3000! OK?";
//      //String pattern = "(\\D*)(\\d+)(.*)";
//      String pattern = "(\\d+)(.*)";
//      // ���� Pattern ����
//      Pattern r = Pattern.compile(pattern);
// 
//      // ���ڴ��� matcher ����
//      Matcher m = r.matcher(line);
//      if (m.find( )) {
//         System.out.println("Found value: " + m.group(0) );
//         System.out.println("Found value: " + m.group(1) );
//         System.out.println("Found value: " + m.group(2) );
////         System.out.println("Found value: " + m.group(3) ); 
//      } else {
//         System.out.println("NO MATCH");
//      }
//   }
//}

import java.util.Scanner;
public class regularExp {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String word = sc.next();
             
            if(isAllUpCase(word) && isConEql(word) && isThrEql(word))
                System.out.println("Likes");
            else
                System.out.println("Dislikes");
        }
    }
    //����1
     public static boolean isAllUpCase(String word){
        return word.matches("[A-Z]+");//+ ����һ�λ���ƥ��ǰ����ַ����ӱ��ʽ
    }
    //����2
    public static boolean isConEql(String word){
        return !word.matches(".*(.)(\\1).*");
    }
    //����3
    public static boolean isThrEql(String word){
        return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }
}