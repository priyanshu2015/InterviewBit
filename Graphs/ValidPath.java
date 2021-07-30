package Graphs;
import java.util.*;
public class ValidPath {
    static int[][] dir = {{-1, 0}, {0,1}, {1, 0}, {0, -1}, {-1, 1}, {1,1}, {1, -1}, {-1,-1}};
    public static boolean isValid(int x, int y, int m, int n){
        if(x>=0 && x<m && y>=0 && y<n){
            return true;
        }
        return false;
    }
    public static int helper(int[][] grid, int x, int y, int[][] visited){
        if(x == grid.length-1 && y == grid[0].length-1){
            return 1;
        }
        visited[x][y] = 1;
        int ans = 0;
        for(int i = 0;i<8; i++){
            int newx = x+dir[i][0];
            int newy = y+dir[i][1];
            
            if(isValid(newx, newy, grid.length, grid[0].length) && visited[newx][newy]!=1 && grid[newx][newy] == 0){
                ans = helper(grid, newx, newy, visited);
                if(ans == 1){
                    return 1;
                }
            }
        }
        return ans;
    }
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] grid = new int[A+1][B+1];
        for(int i = 0; i<=A; i++){
            for(int k = 0; k<=B; k++){
                for(int j = 0; j<C;j++){
                    double d = Math.sqrt(Math.pow(E.get(j) - i, 2) + Math.pow(F.get(j) - k, 2));
                    if(d<=(double)D){ 
                        grid[i][k] = 1;
                    }
                }
            }
        }
        int visited[][] = new int[A+1][B+1];
        if(helper(grid, 0, 0, visited) == 1){
            return "YES";
        }else{
            return "NO";
        }
    }
}
