public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    public static Node buildTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node[] nodes = new Node[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;

            if (leftIndex < arr.length) {
                nodes[i].left = nodes[leftIndex];
            }

            if (rightIndex < arr.length) {
                nodes[i].right = nodes[rightIndex];
            }
        }

        return nodes[0];
    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
