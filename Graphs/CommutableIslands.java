package Graphs;

import java.util.*;
class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;
    Edge(int v1, int v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    public int compareTo(Edge e){
        return this.weight - e.weight;
    }
}
class Node{
    int vertex;
    int weight;
    int getCost(){
        return weight;
    }
}
public class CommutableIslands {
    public static int findMin(int[] weight, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int min_i = Integer.MAX_VALUE;
        for(int i=0;i<weight.length;i++){
            if(visited[i] == false){
                //System.out.println(i);
                if(weight[i]<min){
                    min = weight[i];
                    min_i = i;
                }
            }
        }
        return min_i;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> arr) {
        //Prim's Algorithm
        // A - Vertices
        // B - Edges
        // int parent[] = new int[A];
        // int weight[] = new int[A];
        // PriorityQueue<Node> weightHeap = new PriorityQueue<>(new Comparator<Node>()
        // {
        //         public int compare(Node node1, Node node2)
        //         {
        //             if (node1.getCost() < node2.getCost())
        //             {
        //                 return -1;
        //             }
        //             else if (node1.getCost() < node2.getCost())
        //             {
        //                 return 1;
        //             }

        //             return 0;
        //         }
        // });
        // ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        // for(int i=0;i<A;i++){
        //     ArrayList<Integer> sub = new ArrayList<>();
        //     for (int j = 0; j < A; j++){
        //         sub.add(0);
        //     }
        //     B.add(sub);
        // }

        // for(int i=0;i<arr.size();i++){
        //     B.get(arr.get(i).get(0)-1).set(arr.get(i).get(1)-1, arr.get(i).get(2));
        //     B.get(arr.get(i).get(1)-1).set(arr.get(i).get(0)-1, arr.get(i).get(2));
        // }
        // Arrays.fill(weight, Integer.MAX_VALUE);
        // weight[0] = 0;
        // parent[0] = -1;
        // boolean visited[] = new boolean[A];
        // for(int i=0;i<A;i++){
        //     int v = findMin(weight, visited);
        //     if(v == Integer.MAX_VALUE){
        //         break;
        //     }
        //     visited[v] = true;
        //     for(int j=0;j<A;j++){
        //         if(visited[j] == false && B.get(v).get(j)!=0 && B.get(v).get(j)<weight[j]){
        //             parent[j] = v;
        //             weight[j] = B.get(v).get(j);
        //             //System.out.println(weight[j]);
        //         }
        //     }
        // }
        // int ans = 0;
        // for(int a:weight){
        //     ans+=a;
        // }
        // return ans;

        //Kruskal's Algorithm
        int parent[] = new int[A];
        for(int i=0;i<A;i++){
            parent[i] = i;
        }
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            Edge edge = new Edge(arr.get(i).get(0)-1, arr.get(i).get(1)-1, arr.get(i).get(2));
            edges.add(edge);
        } 
        Collections.sort(edges);
        int count = 0;
        int i = 0;
        int ans = 0;
        while(count!=A-1){
            int pv1 = findParent(edges.get(i).v1, parent);
            int pv2 = findParent(edges.get(i).v2, parent);
            if(pv1 != pv2){
                parent[pv1] = pv2;
                ans+=edges.get(i).weight;
                count++;
            }
            i++;
        }
        return ans;
    }
    public static int findParent(int edge, int[] parent){
        while(edge!=parent[edge]){
            edge = parent[edge];
        }
        return edge;
    }
}

