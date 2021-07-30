package Graphs;
import java.util.*;
public class RegionInBinaryMatrix {
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}, {-1, 1}, {1,1}, {1,-1}, {-1,-1}};
    public static boolean isValid(int i, int j, int n, int m){
        if(i<n && i>=0 && j<m && j>=0){
            return true;
        }
        return false;
    }
    public static int help(ArrayList<ArrayList<Integer>> A, boolean[][] visited, int x, int y){
        
        int ans = 0;
        for(int i=0;i<8;i++){
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if(isValid(newx, newy, A.size(), A.get(0).size()) && visited[newx][newy]==false && A.get(newx).get(newy) == 1){
                visited[newx][newy] = true;
                ans+=help(A, visited, newx, newy);
                ans++;
            }
        }
        return ans;
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        boolean visited[][] = new boolean[n][m];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(visited[i][j]==false && A.get(i).get(j) == 1){
                    visited[i][j] = true;
                    ans = Math.max(help(A, visited, i, j), ans);
                }
            }
        }
        return ans+1;
    }
    
}
