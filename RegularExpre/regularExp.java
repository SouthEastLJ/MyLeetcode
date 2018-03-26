package regularExpress;


//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
// 
//public class regularExp
//{
//    public static void main( String args[] ){
// 
//      // 按指定模式在字符串查找
//      String line = "This order was placed for QT3000! OK?";
//      //String pattern = "(\\D*)(\\d+)(.*)";
//      String pattern = "(\\d+)(.*)";
//      // 创建 Pattern 对象
//      Pattern r = Pattern.compile(pattern);
// 
//      // 现在创建 matcher 对象
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
    //条件1
     public static boolean isAllUpCase(String word){
        return word.matches("[A-Z]+");//+ 代表一次或多次匹配前面的字符或子表达式
    }
    //条件2
    public static boolean isConEql(String word){
        return !word.matches(".*(.)(\\1).*");
    }
    //条件3
    public static boolean isThrEql(String word){
        return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
    }
}