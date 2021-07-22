package BackTracking;
import java.util.*;
public class KthPermutationSequence{
    // Method 1 - Finding all permutations and then sorting. Time Complexity - O(N!)
    // Method 2 - Used Below. Time Complexity - 
    // Method 3 - 
    public static String sortString(String inputString){
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
    public static String swap(String s, int i, int j){
        if(i >= s.length()){
            return "";
        }
        char a = s.charAt(i);
        String s2 = s.substring(0, i) + s.charAt(j) + s.substring(i+1);
        s2 = s2.substring(0, j) + a + s2.substring(j+1);
        return s2; 
    }
    public static String helper(String s, int[] B, int i){
        if(i == s.length() - 1){
            B[0] = B[0]-1;
        }
        if(B[0]==0){
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        String ans = "";
        for(int j=i;j<s.length();j++){
            String s2 = swap(s, i, j);
            if(s2.equals("")){
                continue;
            }
            if(!map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i), 1);
                String s3 = s2.substring(0,i+1) + sortString(s2.substring(i+1));
                
                ans = helper(s3, B, i+1);
                System.out.println(ans);
                if(!ans.equals("")){
                    
                    return ans;
                }
            }
        }
        return ans;
    }
    public String getPermutation(int A, int C) {
        String s = "";
        for(int i=1;i<=A;i++){
            s+=i;
        }
        int B[] = {C};
        return helper(s, B, 0);
    }
}