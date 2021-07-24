package Arrays;
import java.util.*;
public class MaximumSumSquareSubMatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int max = Integer.MIN_VALUE;
        for(int k=0;k<=(A.size()-B);k++){
            for(int l = 0; l<=(A.size()-B); l++){
            int sum = 0;
                for(int i = k; i<k+B; i++){
                    for(int j=l; j<l+B; j++){
                        sum += A.get(i).get(j);
                    }
                }
            if(sum>max){
                max = sum;
            }
            }
        }
        return max;
    }
}
