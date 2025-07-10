import java.util.ArrayList;

public class TreeDepthAndFindLeafNodes {

    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        int index = -1;
        int treeDepth = 0;
        ArrayList<Integer> leafNodes = new ArrayList<>();

        public Node buildTree(int[] nodes){
            if(index < nodes.length - 1){
                index++;

                if(nodes[index] == -1) return null;

                Node newNode = new Node(nodes[index]);
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);
                
                return newNode;
            }
            return null;
        } 

        public int findTreeDepth(Node root){
            if(root == null) return 0;
            int leftHeight = findTreeDepth(root.left);
            int rightHeight = findTreeDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }

        public ArrayList<Integer> getLeafNodes(Node root){
            if(root.left == null && root.right == null){
                leafNodes.add(root.value);
                return leafNodes;
            }
            if(root.left != null) getLeafNodes(root.left);
            if(root.right != null) getLeafNodes(root.right);
            return leafNodes;
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,7,-1,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        int depthOfTree = tree.findTreeDepth(root);
        System.out.println("Tree Depth is : "+depthOfTree);
        ArrayList<Integer> leafNodesOfTree = tree.getLeafNodes(root);

        System.out.print("Leaf Nodes Are : ");
        for(int leafNode : leafNodesOfTree){
            System.out.print(leafNode + ",");
        }
    }
}
