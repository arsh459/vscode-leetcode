package GraphDs;

import java.util.ArrayList;

public class ArticulationPoint {
    // In undirected graphs
    // Articulation point is vertex in an undirected connected graph if removing it disconnect the graph.

    // it is very useful in networks, to find a node if it fails whole network should stay connected.
    
    // Ancestor - A node A that was discovered before curr node in dfs, is an ancestor of currNode

    // node is ap if node is end point means it;s parent is -1(starting point of dfs) 
    // and it disconnected children > 1
    
    // u ---> v there should be single path only then u is AP.

    // u ---> v and there is cycle from u, then also u is AP. 

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

        graph[4].add(new Edge(4, 3));
    }



    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] 
        vis, int time, int[] dt, int[] low, int par, boolean[] ap){

        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children =0;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(e.dest==par){
                continue;
            }

            else if(!vis[e.dest]){
                dfs(graph, e.dest, vis,time, dt,low,curr,ap);
                low[curr] = Math.min(low[curr],low[e.dest]);

                if(dt[curr]<=low[e.dest] && par !=-1){
                    ap[curr]=true;
                }
                children++;

            }

            else if(vis[e.dest]){
                low[curr] = Math.min(low[curr],dt[e.dest]);
            }


            if(par==-1 && children>1){
                ap[curr]= true;

            }
        }
    }

    public static void aP(ArrayList<Edge>[] graph){
        int v = graph.length;
        boolean[] vis= new boolean[v];
        boolean[] ap= new boolean[v];
        int[] dt = new int[v];
        int[] low = new int[v];

        int time=0;

        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph, i, vis, time, dt,low,-1, ap);
            }
        }

        for(int i=0;i<v;i++){
            if(ap[i]){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args){
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        aP(graph);
    }    
}
