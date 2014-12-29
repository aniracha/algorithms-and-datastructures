package pack1;

import java.util.ArrayList;

class TreeNode {
    double value;
    TreeNode left;
    TreeNode right;

    TreeNode(final double value) {
        this.value = value;
    }
}

public class LevelOrderTraversal {

    TreeNode root;

    public static void main(final String args[]) {
        final LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.insertNode(100.00);
        levelOrderTraversal.insertNode(50.00);
        levelOrderTraversal.insertNode(40.00);
        levelOrderTraversal.insertNode(60.00);
        levelOrderTraversal.insertNode(120.00);
        levelOrderTraversal.inorder(levelOrderTraversal.root);
        levelOrderTraversal.printLevelOrder();

    }

    void printLevelOrder() {
        System.out.println();
        System.out.println();
        final ArrayList<ArrayList<TreeNode>> finalResult = new ArrayList<ArrayList<TreeNode>>();
        final ArrayList<TreeNode> intermediate = new ArrayList<TreeNode>();
        intermediate.add(root);
        finalResult.add(intermediate);
        int level = 0;
        while (true) {
            final ArrayList<TreeNode> intermediate1 = new ArrayList<TreeNode>();
            for (final TreeNode treeNode : finalResult.get(level)) {
                if (treeNode.left != null) {
                    intermediate1.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    intermediate1.add(treeNode.right);
                }
            }
            if (intermediate1.isEmpty()) {
                break;
            } else {
                level++;
                finalResult.add(level, intermediate1);
            }
        }

        for (final ArrayList<TreeNode> tn : finalResult) {
            for (final TreeNode tn1 : tn) {
                System.out.print(tn1.value + " ");
            }
            System.out.println();
        }
    }

    void inorder(final TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.value);
            inorder(node.right);
        }
    }

    void insertNode(final double value) {

        final TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
            return;
        }

        boolean isLeftChild = false;
        TreeNode current = root;
        TreeNode parent = null;
        while (current != null) {
            parent = current;
            if (value <= current.value) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        if (isLeftChild) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

    }

}
