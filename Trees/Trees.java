import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Trees {
    public static void main(String[] args) {

        Node root =null;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        root=Trees.addNode(queue);

        preorder(root);
    }

    public static Node addNode(ArrayDeque<Node> queue) {
       int x=1;
       Node head = new Node(x);
       queue.add(head);
       Node temp;
       Scanner sc = new Scanner(System.in);
       while(!queue.isEmpty()){
           temp=queue.poll();
           System.out.println("Enter element to add to left:");
           int left=sc.nextInt();
           if(left!=-1){
               temp.left= new Node(left);
               queue.add(temp.left);
           }
           System.out.println("Enter element to add to right:");
           int right=sc.nextInt();
           if(right!=-1){
               temp.right= new Node(right);
               queue.add(temp.right);
           }
       }

        return head;
    }



    //Recursive left-right tree creation

    public static Node addNode2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element to add: ");
        int x=sc.nextInt();

        if(x==-1){
            return null;
        }
        Node temp = new Node(x);
        temp.left = addNode2();
        temp.right = addNode2();

        return temp;

    }

    public static void preorder(Node root) {
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if(root==null){
            return ;
        }
        preorder(root.left);
        System.out.println(root.val);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if(root==null){
            return ;
        }
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.val);
    }


    public static void levelorder(Node root) {
        if(root==null){
            return ;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }
}
