package LinkedLists;
import java.util.*;

class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
public class ReorderList {
    
    // Approach_1 Time-O(N) Space-O(N)
    public ListNode reorderList(ListNode A) {
        Stack<ListNode> s = new Stack<>();
        ListNode root = A;
        int n = 0;
        while(root!=null){
            s.push(root);
            root = root.next;
            n++;
        }
        root = A;
        int count = 0;
        ListNode next = null;
        while(count<=n){
            if(count%2==0){
                ListNode stop = s.pop();
                if(stop == root){
                    root.next = null;
                    break;
                }
                next = root.next;
                root.next = stop;
            }else{
                if(next == root){
                    root.next = null;
                    break;
                }
                root.next = next;
            }
            count++;
            root = root.next;
        }
        return A;
    }

    // Approach_2 Time-O(N) Space-O(1)
    public static ListNode reorderList_2(ListNode A){
        if(A==null || A.next==null){
            return A;
        }
        ListNode p1 = A;
        ListNode p2 = A;
        ListNode p1_prev = A;
        if(A!=null){
        while(p2!=null && p2.next!=null){
                p1_prev = p1;
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        p1_prev.next = null;
        ListNode prev = null;
        ListNode root = p1;
        while(root!=null){
            ListNode temp = root.next;
            root.next = prev;
            prev = root;
            root = temp;
        }
        //prev holds value
        ListNode next = null;
        ListNode head = A;
        while(true){
            next = head.next;
            head.next = prev;
            if(prev == null){
                break;
            }
            head = head.next;
            prev = prev.next;
            head.next = next;
            if(next!=null)
            head = head.next;
            else
            {head.next = prev;
            break;}
        }
        
        return A;
    }
}
