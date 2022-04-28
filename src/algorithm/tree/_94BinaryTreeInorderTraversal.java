package algorithm.tree;

import algorithm.common.TreeNode;

public class _94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        printNode(node1);
    }

    private static TreeNode printNode(TreeNode node) {
        if (node == null) {
            return node;
        }
        // pre order - root, left, right
        // 1 2 4 5 3 6 7
        // System.out.print(" " + node.val);
        TreeNode left = printNode(node.left);
        // in order -  left, root, right
        // 4 2 5 1 6 3 7
        // System.out.print(" " + node.val);
        TreeNode right = printNode(node.right);
        // in order -  left, right, root
        // 4 5 2 6 7 3 1
        System.out.print(" " + node.val);
        return node;
    }

}
