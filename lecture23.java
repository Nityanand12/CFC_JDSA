import java.util.*;

import javax.swing.undo.StateEdit;

public class lecture23 {
  static class Edge{
    int v,w;
    Edge(int v,int w){
      this.v=v;
      this.w=w;
    }
  }
  public static void addEdge(int u,int v, int wt,ArrayList<Edge> graph[]){
    if(u<0||v<0||u>=graph.length||v>=graph.length) return;
    graph[u].add(new Edge(v,wt));
    graph[v].add(new Edge(u,wt));
  }
  public static void createGraph(ArrayList<Edge> graph[]){
    for(int i=0;i<graph.length;i++){
      graph[i]= new ArrayList<Edge>();
    }
    addEdge(0,1,10,graph);
    // addEdge(0,6,1,graph);
    addEdge(0,3,5,graph);
    addEdge(1,2,15,graph);
    addEdge(2,3,20,graph);
    addEdge(3,4,40,graph);
    addEdge(4,5,25,graph);
    addEdge(4,6,35,graph);
    addEdge(5,6,30,graph);
    // addEdge(8,9,11,graph);
    // addEdge(9,10,21,graph);
    // addEdge(8,10,6,graph);
  }
  public static void display(ArrayList<Edge> graph[]){
    for(int i=0;i<graph.length;i++){
      System.out.print(i+" -> ");
      for(int j=0;j<graph[i].size();j++){
        System.out.print("("+graph[i].get(j).v+" "+graph[i].get(j).w+") ");
      }
      System.out.println();
    }
  }
  public static boolean hasPath(int src,int des,ArrayList<Edge> graph[],boolean vis[]){
    if(src==des) return true;
    boolean res=false;
    vis[src]= true;
    for(Edge e: graph[src]){
      if(!vis[e.v])
      res= res||hasPath(e.v,des,graph,vis);
    }
    return res;
  }
  public static void hasPath(ArrayList<Edge> graph[]){
    boolean vis[]= new boolean[graph.length];
    System.out.println(hasPath(0,6,graph,vis));
  }
  public static void printAllPath(int src,int des,ArrayList<Edge> graph[], boolean vis[],String ans){
    if(src==des){
      System.out.println(ans);
      return ;
    }
    vis[src]= true;
    for(Edge e: graph[src]){
      if(!vis[e.v]){
        printAllPath(e.v,des,graph,vis,ans+"->"+e.v);
      }
    }
    vis[src]= false;
  }
  public static void printAllPath(ArrayList<Edge> graph[]){
    boolean vis[]= new boolean[graph.length];
    printAllPath(0,6,graph,vis,"0");
  }
  public static void hamiltonianPath(int src,int count,ArrayList<Edge> graph[],boolean vis[], String ans){
    if(count== vis.length){
      System.out.println("Path "+ans);
      return;
    }
    vis[src]=true;
    for(Edge e: graph[src]){
      if(!vis[e.v]){
        hamiltonianPath(e.v,count+1,graph,vis,ans+"->"+e.v);
      }
    }
    vis[src]= false;
  }
  public static void hamiltonianPath(ArrayList<Edge> graph[]){
    boolean vis[]= new boolean[graph.length];
    hamiltonianPath(0,1,graph,vis,"0");
  }
  public static void hamiltonianCycle(int src,int osrc,int count,ArrayList<Edge> graph[],boolean vis[], String ans){
    if(count== vis.length){
      for(Edge e: graph[src]){
        if(e.v==osrc){
          System.out.println("Cycle "+ans);
        }
      }
      return;
    }
    vis[src]=true;
    for(Edge e: graph[src]){
      if(!vis[e.v]){
        hamiltonianCycle(e.v,osrc,count+1,graph,vis,ans+"->"+e.v);
      }
    }
    vis[src]= false;
  }
  public static void hamiltonianCycle(ArrayList<Edge> graph[]){
    boolean vis[]= new boolean[graph.length];
    hamiltonianCycle(0,0,1,graph,vis,"0");
  }
  public static void getConnectedComponent(int src,ArrayList<Edge> graph[],boolean vis[]){
    vis[src]= true;
    for(Edge e: graph[src]){
      if(!vis[e.v]){
        getConnectedComponent(e.v,graph,vis);
      }
    }
  }

  public static void getConnectedComponent(ArrayList<Edge> graph[]){
    boolean vis[]= new boolean[graph.length];
    int ans=0;
    for(int i=0;i<vis.length;i++){
      if(!vis[i]){
        ans++;
        getConnectedComponent(i,graph,vis);
      }
    }
    System.out.println(ans);
  }
  public static int detectCycle(int src,ArrayList<Edge> graph[],boolean vis[]){
    Queue<Edge>que= new LinkedList<>();
    que.add(new Edge(src,0));
    int ans=0;
    while(que.size()!=0){
      Edge removeEdge= que.remove();
      if(vis[removeEdge.v]==true){
        ans++;
        continue;
      }
      vis[removeEdge.v]= true;
      for(Edge e: graph[removeEdge.v]){
        if(!vis[e.v]){
          que.add(new Edge(e.v,e.w));
        }
      }
    }
    return ans;
  }
  public static void detectCycle(ArrayList<Edge> graph[]){
    boolean vis[]= new boolean[graph.length];
    int ans=0;
    for(int i=0;i<vis.length;i++){
      if(!vis[i]){
      ans+= detectCycle(i,graph,vis);
      }
    }
    System.out.println(ans);
  }
  public static void main(String[] args) {
    ArrayList<Edge> graph[]= new ArrayList[7];
    // ArrayList<Edge> graph[]= new ArrayList[11];
    createGraph(graph);
    display(graph);
    // hasPath(graph);
    // printAllPath(graph);
    // hamiltonianPath(graph);
    // hamiltonianCycle(graph);
    // getConnectedComponent(graph);
    // detectCycle(graph);
    
  }
}
