package GraphDs;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {

    // Strongly connected components
    // Scc is a component in which we can reach every vertex of a component from every other 
    // other vertex of a component
    // Scc is sub graph of a graph


    // we use modified dfs for this
    // we use reverse DFS - we start from last node

    // steps to get reverse dfs
    // step 1 - Get nodes in stack (topological sort) - dfs with last element inserted in stack O(v+e)
    // step 2 - Transpose the graph - reverse the direction of edges of graph - O(v+e)
    // step 3 - do DFS according to stack nodes on the transpose graph


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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> st){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis,st);
            }
        }

        st.push(curr);
    }

    public static ArrayList<Edge>[]  createTransposeGraph(ArrayList<Edge> graph[]){
        int v = graph.length;
        ArrayList<Edge> transposeGraph[] = new ArrayList[v];
        for(int i=0;i<v;i++){
            transposeGraph[i]= new ArrayList<>();
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e =  graph[i].get(j);
                transposeGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        return transposeGraph;
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void ka(ArrayList<Edge>[] graph){
        int v = graph.length;
        Stack<Integer> s = new Stack<>();
        boolean[] vis= new boolean[v];

        // step 1
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topSort(graph,i, vis, s);
            }
        }

        // step 2
        ArrayList<Edge> transposeGraph[] = createTransposeGraph(graph);

        // step 3
        vis= new boolean[v];
        while (!s.isEmpty()) {
            if(!vis[s.peek()]){
                dfs(transposeGraph,s.pop(), vis);   
                System.out.println();
            }
        }

    }

    public static void main(String[] args){
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        ka(graph);
    }
    
}
