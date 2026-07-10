import java.util.*;
public class CousinNodes {

    public static boolean areCousins(Node root, int x, int y) {
        if (root == null || x == y) {
            return false;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                // Check if x and y are siblings
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                if (node.left != null) {
                    if (node.left.val == x) foundX = true;
                    if (node.left.val == y) foundY = true;

                    queue.offer(node.left);
                }

                if (node.right != null) {
                    if (node.right.val == x) foundX = true;
                    if (node.right.val == y) foundY = true;

                    queue.offer(node.right);
                }
            }

            // Both found at same level and sibling case already eliminated
            if (foundX && foundY) {
                return true;
            }

            // Only one found at this level -> different depths
            if (foundX || foundY) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9,10};
        Node root = Node.buildTree(arr);

        System.out.println(areCousins(root, 6, 4));
    }
}