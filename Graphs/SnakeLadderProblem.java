package Graphs;
import java.util.*;
class Node{
    int value;
    ArrayList<Node> components;
    Node(int value){
        this.value = value;
        components = new ArrayList<>();
    }
}
public class SnakeLadderProblem {
    // BFS to find shortest path
    public static int bfs(ArrayList<Node> nodes, int start, int end){
        Queue<Node> q1 = new LinkedList<>();
        q1.add(nodes.get(0));
        int dist[] = new int[100];
        boolean visited[] = new boolean[100];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!q1.isEmpty()){
            Node pop = q1.remove();
            visited[pop.value-1] = true;
            for(int i=0;i<pop.components.size();i++){
                if(visited[pop.components.get(i).value-1]==false)
                q1.add(pop.components.get(i));
                dist[pop.components.get(i).value-1] = Math.min(dist[pop.components.get(i).value-1], dist[pop.value-1]+1);
            }
        }
        if(dist[99] == Integer.MAX_VALUE)
        return -1;
        return dist[99];
    }
    public int snakeLadder(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        //int grid[][] = new int[10][10];
        // A -> Ladder N*2 N>=1
        // B -> Snakes M*2 M<=15
        // to find - least number of dice rolls to reach grid[0][0]
        // roll from 1 to 6 but in a single any number of times with different number
        int i = 1;
        ArrayList<Node> nodes = new ArrayList<>();
        for(int k=1;k<=100;k++){
            Node n = new Node(k);
            nodes.add(n);
        }
        while(i<=99){
            for(int j = i+1; j<=(i+6); j++){
                int flag = 0;
                if(j>100){
                    continue;
                }
                for(int k=0;k<A.size();k++){
                    if(A.get(k).get(0) == j){
                        nodes.get(i-1).components.add(nodes.get(A.get(k).get(1)-1));
                        flag = 1;
                        break;
                    }
                }
                for(int k=0;k<B.size();k++){
                    if(B.get(k).get(0) == j){
                        nodes.get(i-1).components.add(nodes.get(B.get(k).get(1)-1));
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    nodes.get(i-1).components.add(nodes.get(j-1));
                }
            }
            i++;
        }
        return bfs(nodes, 1, 100);
    }
}
