public class IdenticalTrees {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7,8};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};


        Node root1 = Node.buildTree(arr1);
        Node root2 = Node.buildTree(arr2);


        System.out.println(checkIdentical(root1, root2));

    }

    public static boolean checkIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }


        if (root1.val == root2.val) {
            return checkIdentical(root1.left, root2.left) && checkIdentical(root1.right, root2.right);
        }

        return false;
    }


    public static boolean checkMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        //Omitted the if condition merging it directly to the return statement
        return root1.val == root2.val
                && checkMirror(root1.left, root2.right)
                && checkMirror(root1.right, root2.left);
    }

    public static void createMirror(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        createMirror(root.left);
        createMirror(root.right);

    }

    //Check if the tree is balanced or not

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = Node.height(root.left);
        int rightHeight = Node.height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}