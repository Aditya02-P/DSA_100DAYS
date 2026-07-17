public class BTFtraversal {
    public static void main(String[] args) {
//        int[] inorder = {4, 2, 8, 5, 9, 1, 6, 3, 7, 10};
//        int[] preorder = {1, 2, 4, 5, 8, 9, 3, 6, 7, 10};
//
//
//        Node root = buildTreeInPre(inorder, preorder, 0, 0, inorder.length - 1);

        int[]inorder={4,2,6,5,7,1,10,8,9,3};
        int[] postorder={4,6,7,5,2,10,9,8,3,1};

        Node root = buildTreeInPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

        Trees.preorder(root);
    }

    private static Node buildTreeInPre(int[] inorder, int[] preorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        Node root = new Node(rootValue);

        int rootInorderIndex = findNodeIndex(inorder, rootValue, inStart, inEnd);
        if (rootInorderIndex == -1) {
            return null;
        }

        int leftSubtreeSize = rootInorderIndex - inStart;

        root.left = buildTreeInPre(inorder, preorder, preStart + 1, inStart, rootInorderIndex - 1);

        root.right = buildTreeInPre(inorder, preorder, preStart + 1 + leftSubtreeSize, rootInorderIndex + 1, inEnd);

        return root;
    }

    private static int findNodeIndex(int[] inorder, int targetValue, int searchStart, int searchEnd) {
        for (int i = searchStart; i <= searchEnd; i++) {
            if (inorder[i] == targetValue) {
                return i;
            }
        }
        return -1;
    }

    private static Node buildTreeInPost(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // Base Case: If there are no elements to process
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // 1. The last element in postorder is always the root of the current subtree
        int rootValue = postorder[postEnd];
        Node root = new Node(rootValue);

        // 2. Find where this root splits the inorder array
        int rootInorderIndex = findNodeIndex(inorder, rootValue, inStart, inEnd);
        if (rootInorderIndex == -1) {
            return null;
        }

        // 3. Calculate how many nodes are in the right subtree
        int rightSubtreeSize = inEnd - rootInorderIndex;

        // 4. Build the right subtree
        // Inorder range: right of the root node
        // Postorder range: right before the current root, spanning rightSubtreeSize elements
        root.right = buildTreeInPost(
                inorder, rootInorderIndex + 1, inEnd,
                postorder, postEnd - rightSubtreeSize, postEnd - 1
        );

        // 5. Build the left subtree
        // Inorder range: left of the root node
        // Postorder range: the remaining elements on the left side
        root.left = buildTreeInPost(
                inorder, inStart, rootInorderIndex - 1,
                postorder, postStart, postEnd - rightSubtreeSize - 1
        );

        return root;
    }
}