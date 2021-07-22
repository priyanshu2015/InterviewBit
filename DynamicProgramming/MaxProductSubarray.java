package DynamicProgramming;
import java.util.*;
public class MaxProductSubarray {
    public static int helper(final List<Integer> A, int i, int product, int[] dp){
        if(i==A.size()){
            return product;
        }
        // if(dp[i]!=-1){
        //     return dp[i];
        // }
        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;
        if(i==0){
            ans1 = helper(A, i+1, A.get(i), dp);
        }else{
            ans1 = helper(A, i+1, product*A.get(i), dp);
            ans2 = helper(A, i+1, A.get(i), dp);
        }
        dp[i] = Math.max(ans1, Math.max(ans2, product));
        return Math.max(ans1, Math.max(ans2, product));
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int maxProduct(final List<Integer> A) {
        int dp[] = new int[A.size()];
        for(int i=0;i<A.size();i++){
            dp[i] = -1;
        }
        return helper(A, 0, Integer.MIN_VALUE, dp);
    }
    public static void main(String[] args){
        List<Integer> A = Arrays.asList(0, 5, 0, -8, -2, -4, 0, -8, -6, -2, -4, -5, 0, -1, 0, 0, -4, -9, 0, -2, -1, -7, -6, 4, 0, -10, -4, 6, 1, -2);
        System.out.println(maxProduct(A));
    }
}