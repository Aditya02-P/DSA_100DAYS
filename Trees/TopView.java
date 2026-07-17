import java.util.*;

public class TopView {

    // Find minimum horizontal distance
    public static int findMinHD(Node root, int hd) {
        if (root == null) {
            return hd;
        }

        int leftMin = findMinHD(root.left, hd - 1);
        int rightMin = findMinHD(root.right, hd + 1);

        return Math.min(hd, Math.min(leftMin, rightMin));
    }

    // Find maximum horizontal distance
    public static int findMaxHD(Node root, int hd) {
        if (root == null) {
            return hd;
        }

        int leftMax = findMaxHD(root.left, hd - 1);
        int rightMax = findMaxHD(root.right, hd + 1);

        return Math.max(hd, Math.max(leftMax, rightMax));
    }

    public static void topView(Node root) {
        if (root == null) {
            return;
        }

        int minHD = findMinHD(root, 0);
        int maxHD = findMaxHD(root, 0);

        int size = maxHD - minHD + 1;

        // offset shifts minHD to index 0
        int offset = -minHD;

        ArrayList<Integer> topView =
                new ArrayList<>(Collections.nCopies(size, 0));

        ArrayList<Boolean> visited =
                new ArrayList<>(Collections.nCopies(size, false));

        Queue<NodeHD> queue = new ArrayDeque<>();

        // Root HD = 0, shifted index = offset
        queue.offer(new NodeHD(root, 0));

        while (!queue.isEmpty()) {
            NodeHD current = queue.poll();

            Node node = current.node;
            int hd = current.hd;

            int index = hd + offset;

            // First node encountered at this HD
            if (!visited.get(index) ) {
                topView.set(index, node.val);
                visited.set(index, true);
            }

            if (node.left != null) {
                queue.offer(new NodeHD(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.offer(new NodeHD(node.right, hd + 1));
            }
        }

        for (int value : topView) {
            System.out.print(value + " ");
        }
    }

    static class NodeHD {
        Node node;
        int hd;

        NodeHD(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Node root = Node.buildTree(arr);

        topView(root);
    }
}