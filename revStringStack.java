import java.util.Stack;

public class revStringStack {
     public static String rev_str(String str){
          Stack<Character> s=new Stack<>();
          int i=0;
          while(i<str.length()){
               s.push(str.charAt(i));
               i++;
          }
          StringBuilder sb=new StringBuilder("");
          while (!s.isEmpty()) {
               char curr=s.pop();
               sb.append(curr);
          }
          return sb.toString();
     }
     public static void main(String[] args) {
          String str="Aditya is a good boy";
          String result=rev_str(str);
          System.out.println(result);
     }
}
