public class Trie {
     static class Node{
          Node child[]=new Node[26];
          boolean eow=false;

          Node(){
               for(int i=0;i<child.length;i++){
                    child[i]=null;
               }
          }
     }
     public static Node root=new Node();
     public static void insert(String word){
          Node curr=root;
          for(int i=0;i<word.length();i++){
               int idx=word.charAt(i)-'a';
               if(curr.child[idx]==null){
                    curr.child[idx]=new Node();
               }
               curr=curr.child[idx];
          }
          curr.eow=true;
     }
     public static boolean search(String key){
          Node curr=root;
          for(int i=0;i<key.length();i++){
               int idx=key.charAt(i)-'a';
               if (curr.child[idx]==null) {
                    return false;
               }
               curr=curr.child[idx];
          }
          return curr.eow==true;
     }
     public static void main(String[] args) {
          String words[]={"the","there","their","thee","a","any"};
          for(int i=0;i<words.length;i++){
               insert(words[i]);
          }
          System.out.println(search("any"));

     }
}
