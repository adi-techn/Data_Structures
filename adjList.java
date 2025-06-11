import java.util.*;

public class adjList {
     static class Edge{
          int src;
          int dest;
          int wt;

          public Edge(int s,int d,int w){
               this.src=s;
               this.dest=d;
               this.wt=w;
          }
     }
     public static void createGraph(ArrayList<Edge> graph[],int v){
          for(int i=0;i<v;i++){
               graph[i]=new ArrayList<>();
          }

          //0 vertex
          graph[0].add(new Edge(0, 1, 5));
          
          //1 vertex
          graph[1].add(new Edge(1, 0, 5));
          graph[1].add(new Edge(1, 2, 3));
          graph[1].add(new Edge(1, 3, 6));

          //2 vertex
          graph[2].add(new Edge(2, 3, 9));
          graph[2].add(new Edge(2, 1, 3));

          //3 vertex
          graph[3].add(new Edge(3, 2, 9));
          graph[3].add(new Edge(3, 1, 6));
     }
     public static void bfs(ArrayList<Edge> graph[]){
          Queue<Integer> q=new LinkedList<>();
          boolean visited[]=new boolean[graph.length];

          q.add(0); //src vertex

          while(!q.isEmpty()){
               int curr=q.remove();
               if(!visited[curr]){
                    System.out.print(curr+" ");
                    visited[curr]=true;
                    //Finding neighbour
                    for(int i=0;i<graph[curr].size();i++){
                         Edge e=graph[curr].get(i);
                         q.add(e.dest);
                    }
               }
          }
     }
     public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){
          System.out.print(curr+" ");
          vis[curr]=true;

          for(int i=0;i<graph[curr].size();i++){
               Edge e=graph[curr].get(i);
               if(!vis[e.dest]){
                    dfs(graph,e.dest, vis);
               }
          }
     }
     public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
          if(src==dest){
               return true;
          }
          vis[src]=true;
          for(int i=0;i<graph[src].size();i++){
               Edge e=graph[src].get(i);
               if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                    return true;
               }
          }
          return false;
     }
     public static void main(String[] args) {
          int v=5;
          //Array of arraylist containing edge(src,dest,wt)
          @SuppressWarnings("unchecked")
          ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[v];

          createGraph(graph,v);
          //bfs(graph);
          //dfs(graph, 0,new boolean[v]);
          System.out.println("Has Path ::"+hasPath(graph, 0, 2, new boolean[v]));
     }
}
