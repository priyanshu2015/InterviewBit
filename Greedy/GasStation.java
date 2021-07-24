package Greedy;
import java.util.*;
public class GasStation {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int i = 0;
        while(i!=A.size()){
            int currentGas = 0;
            int flag = 0;
            int j = i;
            while(true){
                currentGas += A.get(j);
                if(currentGas >= B.get(j)){
                    currentGas-=B.get(j);
                    j = (j+1)%A.size();
                    if(j == i)
                    break;
                }else{
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
            i++;
        }
        return -1;
    }
}
