package Graphs;
import java.util.*;
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode root = null;
        Queue<UndirectedGraphNode> q1 = new LinkedList<>();
        //Queue<UndirectedGraphNode> q2 = new LinkedList<>();
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        q1.add(node);
        
        int flag = 0;
        UndirectedGraphNode main = null;
        while(!q1.isEmpty()){
            UndirectedGraphNode pop = q1.remove();
            if(flag == 0){
                root = new UndirectedGraphNode(pop.label);
                main = root;
                flag = 1;
                map.put(root.label, root);
            }else{
                //root = q2.remove();
                root = map.get(pop.label);
            }
            for(int i=0;i<pop.neighbors.size();i++){
                if(!map.containsKey(pop.neighbors.get(i).label)){
                    UndirectedGraphNode nei = new UndirectedGraphNode(pop.neighbors.get(i).label);
                    root.neighbors.add(nei);
                    q1.add(pop.neighbors.get(i));
                    //q2.add(nei);
                    map.put(pop.neighbors.get(i).label, nei);
                }else{
                    root.neighbors.add(map.get(pop.neighbors.get(i).label));
                }
            }
        }
        return main;
    }
}
