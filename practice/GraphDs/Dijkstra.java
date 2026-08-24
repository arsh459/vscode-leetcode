package GraphDs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    // shortest path algo
    // the graph can be directed or undirected graph
    // it is generally weighted graph, it weight is not given we can just assume it as 1
    // It works on BFS with priority queue - elements with lower value has higher priority
    // It is greedy algorithm

    // they use some thing called relaxation
    //  suppose u-->v a direct edge exists
    // and from s node we know distance from s ....> u and s....>v then,  ... represents that there may be multiple nodes  
    // between them

    // s...u is 1, s...v is 5, u-->v is 2
    // if(dist[v]> dist[u]+wt[u-->v]){
    //     dist[v]= dist[u]+wt[u-->v]
    // }

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

    // this can be done using priority queue as it will save time to find the shortest distance
    public static int minDistanceNotVisitedNode(boolean[] vis, int[] dis){
        int minDistance=Integer.MAX_VALUE;
        int minIndex= -1;
        for(int i=0;i<dis.length;i++){
            if(!vis[i] && dis[i]<=minDistance){
                minDistance=dis[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public static void findShortestPath(ArrayList<Edge>[] graph, boolean[] vis, int[] dis){
        // using recursion
        // int minDistanceNode = minDistanceNotVisitedNode(vis, dis);
        // if(minDistanceNode==-1){
        //     return;
        // }
        // vis[minDistanceNode]=true;
        // for(int i=0;i<graph[minDistanceNode].size();i++){
        //     Edge e = graph[minDistanceNode].get(i);
        //     // relaxation algo
        //     if(dis[e.dest] > dis[minDistanceNode] + e.wt){
        //         dis[e.dest] = dis[minDistanceNode] + e.wt;
        //     } 
        // }
        // findShortestPath(graph, vis, dis);

        // using iteration
        int minDistanceNode = minDistanceNotVisitedNode(vis, dis);
        while(minDistanceNode!=-1){
            vis[minDistanceNode]=true;
            for(int i=0;i<graph[minDistanceNode].size();i++){
                Edge e = graph[minDistanceNode].get(i);
                // relaxation algo
                if(dis[e.dest] > dis[minDistanceNode] + e.wt){
                    dis[e.dest] = dis[minDistanceNode] + e.wt;
                }
            }
            minDistanceNode= minDistanceNotVisitedNode(vis, dis);
        }        
    }

    // using priorty queue

    // used for optimized distance algo - using prirority queue, in that we will sort by distance, so we get shortest distance
    // at the start of queue, along with that we also need the node index so we are making a pair
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

    // O(E + ElogV)
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dis[] = new int[graph.length];
        for(int i=1;i<graph.length;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[0]=0;
        pq.add(new Pair(0, 0));
        boolean[] vis = new boolean[graph.length];

        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            if(!vis[pair.node]){
                vis[pair.node]= true;
                for(int i=0;i<graph[pair.node].size();i++){
                    Edge e = graph[pair.node].get(i);

                    // relaxation algo
                    if(dis[e.dest] > dis[pair.node] + e.wt){
                        dis[e.dest] = dis[pair.node] + e.wt;
                        pq.add(new Pair(e.dest, dis[e.dest]));
                    }
                }
            }   
        }

    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void main(String[] args){
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        boolean[] vis= new boolean[v];
        int[] dis= new int[v];
        for(int i=1;i<v;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[0]=0;

        findShortestPath(graph, vis, dis);

        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i] + "  ");
        }
    }

}
