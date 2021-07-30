package Graphs;
import java.util.*;
public class WordSearchBoard {
    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public static int helper(char arr[][], int k, int j, String B){
        if(B.length() == 0){
            return 1;
        }
        int n = arr.length;
        int m = arr[0].length;
        int ans = 0;
        for(int i=0;i<4;i++){
            int newx = k + dir[i][0];
            int newy = j + dir[i][1];
            if(isValid(newx, newy, n, m) && (arr[newx][newy] == B.charAt(0))){
                ans = helper(arr, newx, newy, B.substring(1));
                if(ans == 1){
                return ans;}
            }
        }
        return ans;
    }
    public static boolean isValid(int x, int y, int n, int m){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }
    public int exist(ArrayList<String> A, String B) {
        char arr[][] = new char[A.size()][A.get(0).length()];
        for(int i=0;i<A.size();i++){
            arr[i] = A.get(i).toCharArray();
        }
        int result = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == B.charAt(0)){
                    result = helper(arr, i, j, B.substring(1));
                    if(result == 1){
                    return result;
                    }
                }
            }
        }
        return result;
    }
}
