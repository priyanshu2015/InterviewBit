package Graphs;
import java.util.*;
public class BlackShapes {
    int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public void helper(char arr[][], int k, int j, boolean visited[][]){
        int n = arr.length;
        int m = arr[0].length;
        visited[k][j] = true;
        //System.out.println(k + " " + j);
        for(int i=0;i<4;i++){
            int newx = k + dir[i][0];
            int newy = j + dir[i][1];
            if(isValid(newx, newy, n, m) && arr[newx][newy] == 'X' && visited[newx][newy] == false){
                helper(arr, newx, newy, visited);
            }
        }
    }
    public boolean isValid(int x, int y, int n, int m){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }
    public int black(ArrayList<String> A) {
        char arr[][] = new char[A.size()][A.get(0).length()];
        for(int i=0;i<A.size();i++){
            arr[i] = A.get(i).toCharArray();
        }
        //
        int n = A.size();
        int m = A.get(0).length();
        boolean visited[][] = new boolean[n][m];
        int result = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == 'X' && visited[i][j]==false){
                    helper(arr, i, j, visited);
                    //System.out.println(i + " " + j);
                    result++;
                }
            }
        }
        return result;
    }
}
