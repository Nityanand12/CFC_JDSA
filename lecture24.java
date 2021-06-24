import java.util.*;

public class lecture24 {
  static class Edge {
    int v, w;

    Edge(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  public static void addEdge(int u, int v, int wt, ArrayList<Edge> graph[]) {
    if (u < 0 || v < 0 || u >= graph.length || v >= graph.length)
      return;
    graph[u].add(new Edge(v, wt));
    graph[v].add(new Edge(u, wt));
  }

  public static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<Edge>();
    }
    addEdge(0, 1, 10, graph);
    // addEdge(0,6,1,graph);
    addEdge(0, 3, 13, graph);
    addEdge(1, 2, 5, graph);
    addEdge(2, 3, 12, graph);
    // addEdge(3, 4, 4, graph);
    addEdge(4, 5, 2, graph);
    addEdge(4, 6, 15, graph);
    addEdge(5, 6, 5, graph);
    // addEdge(8,9,11,graph);
    // addEdge(9,10,21,graph);
    // addEdge(8,10,6,graph);
  }

  public static void display(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      System.out.print(i + " -> ");
      for (int j = 0; j < graph[i].size(); j++) {
        System.out.print("(" + graph[i].get(j).v + " " + graph[i].get(j).w + ") ");
      }
      System.out.println();
    }
  }

  static class DijikstraPair implements Comparable<DijikstraPair> {
    int src;
    int par;
    int w;
    int wsf;

    DijikstraPair(int src, int par, int w, int wsf) {
      this.src = src;
      this.par = par;
      this.w = w;
      this.wsf = wsf;
    }

    @Override
    public int compareTo(DijikstraPair o) {
      return this.wsf - o.wsf;
    }
  }

  public static void DijikstraAlgo(ArrayList<Edge> graph[], int src) {
    PriorityQueue<DijikstraPair> pq = new PriorityQueue<DijikstraPair>();
    pq.add(new DijikstraPair(src, -1, 0, 0));
    boolean vis[] = new boolean[graph.length];
    while (pq.size() != 0) {
      DijikstraPair remove = pq.poll();
      if (vis[remove.src] == true)
        continue;
      if (remove.par != -1) {
        System.out.println(remove.par + " to " + remove.src + " with weight " + remove.w + " and wsf " + remove.wsf);
      }
      vis[remove.src] = true;
      for (Edge e : graph[remove.src]) {
        if (!vis[e.v]) {
          pq.add(new DijikstraPair(e.v, remove.src, e.w, remove.wsf + e.w));
        }
      }
    }
  }

  static class PrimsPair implements Comparable<PrimsPair> {
    int src;
    int par;
    int w;
    int wsf;

    PrimsPair(int src, int par, int w, int wsf) {
      this.src = src;
      this.par = par;
      this.w = w;
      this.wsf = wsf;
    }

    @Override
    public int compareTo(PrimsPair o) {
      return this.w - o.w;
    }
  }

  public static void PrimsAlgo(ArrayList<Edge> graph[]) {
    PriorityQueue<PrimsPair> pq = new PriorityQueue<PrimsPair>();
    pq.add(new PrimsPair(0, -1, 0, 0));
    boolean vis[] = new boolean[graph.length];
    while (pq.size() != 0) {
      PrimsPair remove = pq.poll();
      if (vis[remove.src] == true)
        continue;
      if (remove.par != -1) {
        System.out.println(remove.par + " to " + remove.src + " with weight " + remove.w + " and wsf " + remove.wsf);
      }
      vis[remove.src] = true;
      for (Edge e : graph[remove.src]) {
        if (!vis[e.v]) {
          pq.add(new PrimsPair(e.v, remove.src, e.w, remove.wsf + e.w));
        }
      }
    }
  }

  static class BipartitePair {
    int vtx = 0;
    int color = 0;

    BipartitePair(int vtx, int color) {
      this.vtx = vtx;
      this.color = color;
    }

    BipartitePair() {

    }
  }
  public static boolean isBipartite(int color[],ArrayList<Edge> graph[],Queue<BipartitePair> que,int id){
    color[id]=0;
    que.add(new BipartitePair(id,0));
    while(que.size()!=0){
      BipartitePair removePair= que.remove();
      for(Edge e: graph[removePair.vtx]){
        if(color[e.v]==-1){
          color[e.v]= (removePair.color+1)%2;
          que.add(new BipartitePair(e.v,(removePair.color+1)%2));
        }
        else if(color[e.v]==color[removePair.vtx]) {
          return false;
        }
      }
    }
    return true;
  }
  public static void isBipartite(ArrayList<Edge> graph[]) {
    Queue<BipartitePair> que = new LinkedList<BipartitePair>();
    int color[]= new int[graph.length];
    for(int i=0;i<graph.length;i++){
      color[i]=-1;
    }
    boolean res= true;
    for(int i=0;i<graph.length;i++){
      if(color[i]==-1){
        res=res&&isBipartite(color,graph,que,i);
      }
    }
    System.out.println(res);
  }

  public static void main(String[] args) {
    ArrayList<Edge> graph[] = new ArrayList[7];
    createGraph(graph);
    display(graph);
    System.out.println("DijikstraAlgo");
    DijikstraAlgo(graph, 0);
    System.out.println("PrimsAlgo");
    PrimsAlgo(graph);
    isBipartite(graph);
  }
}
