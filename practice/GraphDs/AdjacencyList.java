package GraphDs;

import java.util.ArrayList;

public class AdjacencyList {

    // network of nodes
    // vertex - node is also said vertex
    // edge - connection between nodes

    // Application of graphs
    // Maps, social network, delivery network

    // Edge - Uni-directional , Bidirectional|Undirectional
    // weight - weighted , unweighted graphs


    // storing a graph
    // 1. Adjacency List
    // 2. Adjacency Matrix
    // 3. Edge List
    // 4. 2D matrix (implicit graph)


    // 1. Adjacency List
    // List of lists, suppose there is unweighted and undirected graphs and have edges 4 and vertex 4
    // information will be stored vertex wise, like from which vertex i can reach which vertex like neighbours

    // suppose 0 is connected to 2, we will save as {0,2} edgewise with source and destination
    // we will assign each vertex a index so to store in list

    // it can implemented in many ways
    // we will use Array of ArrayLists
    // ArrayList<Edge>[] graph | ArrayList<Edge> graph[] --> it will be of length V
    

    // Adjacency Matrix
    // we will make a matrix of vXv
    // we will store 0 or 1 in matrix we will make i as source and j as destination
    // whereever i->j edge exists we mark 1 in matrix 
    // if it is weighted then we will store weight instead of 0,1
    // here extra space is required which is v^2, in this if we want to find neighbour we will need o(v
    
    // Edge List
    // We will just a list of all the edges
    // we use this when we need to sort the edges 
    // it will be needed in minimum spanning tree problem


    // Implicit Graph
    // It is given in the problem, it is generally 2d array
    // It is used in flood fill algorithm
    
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

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2,2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, -1));
        graph[3].add(new Edge(3, 2, 0));

        printNeighbours(2, graph);
        // printNeighbours(3, graph);

    }

    public static void printNeighbours(int index,ArrayList<Edge> graph[] ){
        ArrayList<Edge> neighbours = graph[index];
        for(int i=0;i<neighbours.size();i++){
            System.out.println(neighbours.get(i).dest +" " + neighbours.get(i).wt);
        }
    }

    public static void main(String[] args){  
        int V = 4;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        
    }
}
