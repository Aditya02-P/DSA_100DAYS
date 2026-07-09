import java.util.*;

public class SpiralLOT {
    public static void main(String[] args) {

        int[]arr = {1,2,3,4,5,6,7,8,9};
        Node head = Node.buildTree(arr);

        List<Integer> list = printSpiralLO(head);
        System.out.println(list);
    }

    public static List<Integer> printSpiralLO(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> stackLR = new ArrayDeque<>();
        Deque<Node> stackRL = new ArrayDeque<>();

        stackRL.push(root);
        while (!stackLR.isEmpty() || !stackRL.isEmpty()) {
            if(!stackRL.isEmpty()){
                while(!stackRL.isEmpty()){
                    Node temp = stackRL.pop();
                    list.add(temp.val);
                    if (temp.right != null) {
                        stackLR.push(temp.right);
                    }
                    if (temp.left != null) {
                        stackLR.push(temp.left);
                    }

                }
            }else{
                while(!stackLR.isEmpty()){
                    Node temp = stackLR.pop();
                    list.add(temp.val);
                    if (temp.left != null) {
                        stackRL.push(temp.left);
                    }
                    if (temp.right != null) {
                        stackRL.push(temp.right);
                    }


                }
            }
        }

        return list;
    }
}
