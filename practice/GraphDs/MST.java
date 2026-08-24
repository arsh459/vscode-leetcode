package GraphDs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
    // minimum spanning tree
    // A minimum spanning tree or minimum weight spanning tree is a subset of edges of a connected,edge weighted
    // undirected graph that connected all the vertices together, without any cycles and with the minimum possible
    // total edge weight

    // it removes the cycles from graph
    // total edge weight should be minimum

    //  A normal graph can have multiple spanning tree,  but mst will be the one with minimum edge weight

    // Prim's algo
    // it works on the principal that we make two sets, one is non-mst set which contains all the vertices 
    // and the one which contains current set , what we do is take source node and then find the minimum edge to its neighbours
    // and make a connection
    // then we have 2 nodes we find next minimum edge among their neighbours and connect
    // then we have 3 nodes we find next minimum edge among their neighbours and connect    


    // we want to find minimum edge weight so we will use priorityQueue
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

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
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

    public static void Prims(ArrayList<Edge>[] graph){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[graph.length];
        pq.add(new Pair(0, 0));

        int mstCost =0;
        while (!pq.isEmpty()) {
            Pair pair= pq.remove();
            if(!vis[pair.node]){
                vis[pair.node]=true;
                mstCost+=pair.dist;
                for(int i=0;i<graph[pair.node].size();i++){
                    Edge e= graph[pair.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }  
            }
                      
        }
        System.out.print(mstCost);

    }

    public static void main(String[] args){
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        
        Prims(graph,0);
    }
}
