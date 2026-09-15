package GraphDs;

import java.util.ArrayList;

public class TarjanAlgo {
    // In undirected graphs
    // bridge is an edge who's deletion increases the graph's number of connected components
    // we use tarjan algo for this

    // articulation point, bridge, topSort, SCC

    // For doing tarjan's algo
    // We first make a discovery time array of size v
    // lowestDT[]
    
    static class Edge{
        int src;
        int dest;

        Edge(int src, int dest){
            this.src= src;
            this.dest=dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }



    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] 
        vis, int time, int[] dt, int[] low, int par){

        vis[curr]=true;
        dt[curr]=low[curr]=++time;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(e.dest==par){
                continue;
            }

            if(!vis[e.dest]){
                dfs(graph, e.dest, vis,time, dt,low,curr);
                low[curr] = Math.min(low[curr],low[e.dest]);

                if(dt[curr]<low[e.dest]){
                    System.out.println(curr + " -- " + e.dest);
                }

            }

            if(vis[e.dest]){
                low[curr] = Math.min(low[curr],dt[e.dest]);
            }
        }
    }

    public static void tA(ArrayList<Edge>[] graph){
        int v = graph.length;
        boolean[] vis= new boolean[v];
        int[] dt = new int[v];
        int[] low = new int[v];

        int time=0;

        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph, i, vis, time, dt,low,-1);
            }
        }
    }

    public static void main(String[] args){
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        tA(graph);
    }    
}
