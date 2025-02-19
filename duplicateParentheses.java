import java.util.Stack;

public class duplicateParentheses {
     public static boolean isDuplicate(String str){
          Stack<Character> s=new Stack<>();
          for(int i=0;i<str.length();i++){
               char ch=str.charAt(i);
               //closing 
               if(ch==')'){
                    int c=0;
                    while(s.peek()!='('){
                         s.pop();
                         c++;
                    }
                    if(c<1){
                         return true;
                    }
                    else{
                         s.pop();
                    }
               }//opening
               else{
                    s.push(ch);
               }
          }
          return false;
     }
     public static void main(String[] args) {
          String s="((a+b))";
          System.out.println(isDuplicate(s));
     }
}
