import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
    int index = -1;

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root;

    static class BinaryTree {
        Queue<Node> q = new LinkedList<>();
        static int index = -1;

        public Node buildTree(int nodes[]) {
            if (index < nodes.length - 1) {
                index++;

                if (nodes[index] == -1) {
                    return null;
                }

                Node newNode = new Node(nodes[index]);

                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);

                return newNode;
            }
            return null;
        }

        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }

        public boolean checkMirrorTreeOrNot(Node root){
            if(root == null) return false;
            q.add(root.left);
            q.add(root.right);

            while (!q.isEmpty()){
                Node left = q.poll();
                Node right = q.poll();

                if(left == null && right == null){
                    continue;
                }
                if(left == null || right == null){
                    return false;
                }
                if(left.value != right.value){
                    return false;
                }
                q.add(left.right);
                q.add(right.left);
                q.add(left.left);
                q.add(right.right);
            }
            return true;
        }

        public boolean checkMirrorTreeOrNotRecursive(Node left,Node right){


            if(left == null && right == null) return true;
            if(left == null || right == null) return false;

            if(left.value == right.value && checkMirrorTreeOrNotRecursive(left.right,right.left) &&
            checkMirrorTreeOrNotRecursive(left.left,right.right)){
                return true;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};

        BinaryTree tree = new BinaryTree();
        root = tree.buildTree(nodes);
        // System.out.println(tree.checkMirrorTreeOrNot(root));
        System.out.println(tree.checkMirrorTreeOrNotRecursive(root.left, root.right));
    }
}