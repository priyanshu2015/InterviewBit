package Graphs;
import java.util.*;
public class CycleInDirectedGraph {
    public static int findTopParent(int[] parent, int i){
        while(i!=parent[i]){
            i = parent[i];
        }
        return i;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] parent = new int[A];
        for(int i=0; i<A ;i++){
            parent[i] = i;
        }
        for(int i =0; i<B.size(); i++){
           int p1 = findTopParent(parent, B.get(i).get(0)-1);
           int p2 = findTopParent(parent, B.get(i).get(1)-1);
           if(p1 == p2){
               return 1;
           }
           parent[B.get(i).get(1)-1] = p1;
        }
        return 0;
    }
}
