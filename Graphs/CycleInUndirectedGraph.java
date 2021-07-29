package Graphs;
import java.util.*;

// Using Union Find Algorithm
public class CycleInUndirectedGraph {
    public static int findTopParent(int[] parent, int i){
        while(i!=parent[i]){
            i = parent[i];
        }
        return i;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] parent = new int[A+1];
        for(int i=0; i<=A ;i++){
            parent[i] = i;
        }
        for(int i =0; i<B.size(); i++){
            //int p1 = findTopParent(parent, B.get(i).get(0));
            int a = B.get(i).get(0);
            while(a!=parent[a]){
            a = parent[a];
            }
            //int p2 = findTopParent(parent, B.get(i).get(1));
            int b = B.get(i).get(1);
            while(b!=parent[b]){
            b = parent[b];
            }
            if(a == b){
                return 1;
            }else{
            parent[a] = b;
            }
        }
        return 0;
    }
}
