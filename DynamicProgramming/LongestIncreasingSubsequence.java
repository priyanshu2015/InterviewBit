package DynamicProgramming;
import java.util.*;
public class LongestIncreasingSubsequence {
    public static int helper(List<Integer> A, int i, int k, int[] dp){
        if(i==A.size()){
            return 0;
        }
        int ans1 = 0;
        int ans2 = 0;
        if(k==-1){
            ans1 = helper(A, i+1, k, dp);
            ans2 = helper(A, i+1, i, dp) + 1;
        }
        else if(A.get(i)>=A.get(k)){
            ans2 = helper(A, i+1, i, dp) + 1;
        }
        else{
            ans1 = helper(A, i+1, k, dp);
        }
        return Math.max(ans1, ans2);
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int lis(final List<Integer> A) {
        int dp[] = new int[A.size()];
        for(int i=0;i<A.size();i++){
            dp[i] = -1;
        }
        return(helper(A, 0, -1, dp));
    }
    public static void main(String[] args){
        //List<Integer> A = Arrays.asList(4,1,2,3,5);
        List<Integer> A = Arrays.asList(69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44, 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89);
        System.out.println(lis(A));
    }
}
