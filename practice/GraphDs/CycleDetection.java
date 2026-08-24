package GraphDs;

import java.util.ArrayList;
import java.util.Stack;

public class CycleDetection {
    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src= src;
            this.dest=dest;
        }
    }
    // undirected graph 
    // We use dfs, bfs , disjoint set union

    public static void createUndirectedGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean isUndirectedCyclic(ArrayList<Edge> graph[], int par, boolean[] vis, int curr){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && par!=e.dest){
                return true;
            }
           if(!vis[e.dest] && isUndirectedCyclic(graph, curr, vis, e.dest)){
            return true;
           }
        }
        return false;
    }

    // if i am going to a node and it is not a parent ,if that is already visited then cycle exists








    // Directed graph
    // so basic theory is that whenever i am going inside using dfs , i am adding elements in recursion stack
    // so that if in single cycle of recursion same element comes again i am in cycle then
    // here we are marking visited but also maintaining a recursion stack - modified dfs 
    // we can use dfs, bfs, topological sort for determining this

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        // Directed graph is just like normal graph, we just make particular edges only like 0,2 but not 2,0
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }


    public static boolean isCyclic(ArrayList<Edge> graph[], int curr, boolean[] vis, boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(isCyclic(graph,e.dest, vis,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }


    // works on directed acyclic graphs (DAG
    // It is a linear order of vertices such if u-->v exists, we make such that u comes before v

    // it shows dependency like structure
    // means one node has to be visited and then only we can reach second node

    // we use modified dfs for this, we just add the element in stack tree as i visiting the nodes
    public static void topologicalSort(ArrayList<Edge> graph[], int start, boolean[] vis, Stack<Integer> st){
        vis[start]=true;
        for(int i=0;i<graph[start].size();i++){
            if(!vis[graph[start].get(i).dest]){
                topologicalSort(graph, graph[start].get(i).dest, vis, st);
            }
        }
        st.add(start);
    }

    public static void topologicalSortIt(ArrayList<Edge> graph[]){
        int V= graph.length;
        boolean[] vis= new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i =0;i<V;i++){
            if(!vis[i]){
                topologicalSort(graph, i, vis, st);
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public static void main(String[] args){  
        int V = 4;
        ArrayList<Edge> graph[]= new ArrayList[4];

        // undirected graph
        createGraph(graph);






        // Directed Graph
        // createGraph(graph);
        // System.out.print(isCyclic(graph, 0, new boolean[V], new boolean[V]));

        // it might be possible it is disconnected
        // boolean[] vis= new boolean[V];
        // boolean[] rec= new boolean[V];
        // for(int i=0;i<graph.length;i++){
        //     if(!vis[i]){
        //         System.out.print(isCyclic(graph, i, vis, rec));
        //     }
        // }
        // topologicalSortIt(graph);
    }
}
