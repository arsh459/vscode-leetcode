package GraphDs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

    // we need to find a starting point first
    // by convention we will take 0 as starting points


    // Go to immidiate neighbours first and their children neighbours
    // indirect level wise traversal
    // we use queue ds
    // o(V+E)

    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src= src;
            this.dest=dest;
        }
    }



     public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));


        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void BFSTraveral(ArrayList<Edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);
        while(!q.isEmpty()){
            Integer curr =  q.remove();
            if(!vis[curr]){
                System.out.println(curr);
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    // disconnected components can also be present in graph
    // here i will run a loop for every vertex and check if every vertex is visited

    // 1-2-3
    // 3-4
    // here if i just take 1 as start, i will miss 3, 4
    // So loop on every vertex
    public static void BFSTraveralDisconnected(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        for(int j=0;j<graph.length;j++){
            if(vis[j]){
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(j);
            while(!q.isEmpty()){
                Integer curr =  q.remove();
                if(!vis[curr]){
                    System.out.println(curr);
                    vis[curr]=true;
                    for(int i=0;i<graph[curr].size();i++){
                        q.add(graph[curr].get(i).dest);
                    }
                }
            }
        }
    }





    // DFS
    // keep going to 1st neighbour
    public static void DFSTraveral(ArrayList<Edge> graph[], int start, boolean[] vis){
        if(vis[start]){
            return;
        }
        System.out.println(start);
        vis[start]=true;
        for(int i=0;i<graph[start].size();i++){
            DFSTraveral(graph, graph[start].get(i).dest, vis);
        }
    }


    // All path from source to target
    // we will traverse for a single path
    // O(v^v) - for every we are going to every other node
    public static void allPathSrcToTarget(ArrayList<Edge> graph[], int curr, int target, String path, boolean[] vis){
        if(curr==target){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr]=true;
                allPathSrcToTarget(graph,e.dest, target, path + e.dest, vis);
                vis[curr]=false;
            }
        }
    }

    public static void main(String[] args){  
        int V = 7;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);

        // BFSTraveral(graph);
        // BFSTraveralDisconnected(graph); // O(V+E)

        // DFSTraveral(graph,0,new boolean[V]);

        // For DFS connected also just make a loop
        // boolean[] vis = new boolean[V];
        // for(int i=0;i<graph.length;i++){
        //     DFSTraveral(graph,i,vis);
        // }


        allPathSrcToTarget(graph,0,5,"0",new boolean[V]);
    }
    


    
}
