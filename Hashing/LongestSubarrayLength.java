package Hashing;
import java.util.*;
public class LongestSubarrayLength {
    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i=0;i<A.size();i++){
            if(A.get(i) == 0){
                sum-=1;
            }else{
                sum+=1;
            }
            if(sum == 1){
                maxLen = i+1;
            }
            else{
                // sum-1 as this means the subarray contains one '1' more than the no. of zeros.
                if(map.containsKey(sum-1)){
                    int len = (i - map.get(sum-1));
                    maxLen = Math.max(maxLen, len);
                }
            }
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxLen;
    }
}
