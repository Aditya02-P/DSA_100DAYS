public class PathInTree {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Node root = Node.buildTree(arr);

        System.out.println(maxSumNode(root));
    }

    public static int maxSumNode(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        int leftSum = maxSumNode(root.left);
        int rightSum = maxSumNode(root.right);

        return root.val + Math.max(leftSum, rightSum);
    }
}
