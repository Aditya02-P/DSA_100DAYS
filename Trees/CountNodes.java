import java.util.ArrayDeque;
import java.util.Queue;

public class CountNodes {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Node root = Node.buildTree(arr);

        maxInEachLevel(root);

    }

    public static int countNodesM(Node root) {
        int count = 0;
        if (root == null) {
            return 0;
        }

        return preorder(root, count);
    }

    public static int preorder(Node root, int count) {
        if (root == null) {
            return count;
        }
        count++;
        count = preorder(root.left, count);
        count = preorder(root.right, count);

        return count;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + leftCount + rightCount;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return root.val + leftSum + rightSum;
    }


    //Problem 4

    public static int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftSum = countLeaves(root.left);
        int rightSum = countLeaves(root.right);

        return leftSum + rightSum;
    }

    //problem 5

    public static int countNonLeaf(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null || root.right != null) {
            return 1 + countNonLeaf(root.left) + countNonLeaf(root.right);
        }

        return 0;
    }


    //Problem 6 -> height of BT (Count the number of nodes in the height)

    public static int height(Node root) {
        return Node.height(root);
    }


    //This only works if the BT is perfect BT , else it fails to print the max of an imperfect level failing the whole flow
    public static void maxInEachLevel(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 1;
        int max = Integer.MIN_VALUE;
        int tiggerAt=1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            max = Math.max(max, node.val);
            if(count==tiggerAt){
                System.out.println(max);
                tiggerAt=tiggerAt*2+1;
            }
            count++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void maxInEachLevelUsed(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {

                Node node = queue.poll();

                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            System.out.println(max);
        }
    }
}
