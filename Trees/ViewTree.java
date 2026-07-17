import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class ViewTree {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8,9};
        Node root = Node.buildTree(arr);

    }


    public static void printLeftView(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i==0){
                    list.add(node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }

        System.out.println(list);
    }

    public static void printLeftViewOp(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        leftView(root, 0, list);
        System.out.println(list);
    }

    private static void leftView(Node root, int level, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        // First node visited at this level
        if (level == list.size()) {
            list.add(root.val);
        }

        leftView(root.left, level + 1, list);
        leftView(root.right, level + 1, list);
    }

    public static void printRightView(Node root) {
        if (root == null) {
            return;
        }
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i==size-1){
                    assert node != null;
                    list.add(node.val);
                }
                assert node != null;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }

        System.out.println(list);
    }

    public static int findRightmostHD(Node root, int hd) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findRightmostHD(root.left, hd - 1);
        int rightMax = findRightmostHD(root.right, hd + 1);

        return Math.max(hd, Math.max(leftMax, rightMax));
    }

    public static int findLeftmostHD(Node root, int hd) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findLeftmostHD(root.left, hd - 1);
        int rightMin = findLeftmostHD(root.right, hd + 1);

        return Math.min(hd, Math.min(leftMin, rightMin));
    }



}
