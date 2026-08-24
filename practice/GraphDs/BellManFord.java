package GraphDs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BellManFord {
    // shortest path algo
    // the graph can be directed or undirected graph
    // it is generally weighted graph, it weight is not given we can just assume it as 1
    // Dikstra does not work on negative weights
    // It is Dynamic programming algo
    // It has more time complexity than dijkstra but it works on negative values
    
    
    // we have to run 2 loop 
    // one for v-1 times // why this because for reaching from a to b maximum nodes that i can have is v-1 
    // nested in for all edges and then perform relaxation


    // It also does not work on negative weight cycles, if my graph contain cycles and it have negative weight
    // like if a-->b--->c--->a in this graph (a,b)+(b,c)+(c,a)<0 it is called negative weight 
    // it also does not make any sense to find shortest distance in negative weight cycles
    // if we want to detect this , run loop one more time after (v-1) and if distances are not same the negative cycle is there  

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src= src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }


    // O(v*e)
    public static void BellmanFord(ArrayList<Edge>[] graph, int src){
        int v= graph.length;
        boolean[] vis= new boolean[v];
        int[] dis= new int[v];
        for(int i=1;i<v;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[0]=0;

        // get all edges - this can be done by creating a graph with edge list
        // o(E)
        ArrayList<Edge> allEdges=new ArrayList<>();
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                allEdges.add(graph[i].get(j));
            }
        }

        for(int i=0;i<v;i++){ // O(v)
            for(int j=0;j<allEdges.size();j++){ // o(E)
                Edge e = allEdges.get(j);
                if(dis[e.src]!=Integer.MAX_VALUE &&  dis[e.dest] > dis[e.src] + e.wt){
                    dis[e.dest] = dis[e.src] + e.wt;
                }

            }
        }

        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i] + "  ");
        }
    }

    public static void main(String[] args){
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        
        BellmanFord(graph,0);
    }

}
