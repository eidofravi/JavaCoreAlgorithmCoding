package algorithm.tree;

import algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathRootToLeaf {
    /*    10
        20 30
        40 50 60 70*/
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(40);
        TreeNode node5 = new TreeNode(50);
        TreeNode node6 = new TreeNode(60);
        TreeNode node7 = new TreeNode(70);
        TreeNode node2 = new TreeNode(20, node4, node5);
        TreeNode node3 = new TreeNode(30, node6, node7);
        TreeNode root = new TreeNode(10, node2, node3);
        List<List<Integer>> allPath = printAllPath(root);
        for (List<Integer> val : allPath) {
            for (Integer val2 : val) {
                System.out.println(val2);
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> printAllPath(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (null == node.left && null == node.right) {
            List<List<Integer>> listAll = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            listAll.add(list);
            return listAll;
        }
        List<List<Integer>> allVal = new ArrayList<>();
        List<List<Integer>> nodeLeftVal = printAllPath(node.left);
        List<List<Integer>> nodeRightVal = printAllPath(node.right);
        for (List<Integer> leftVal : nodeLeftVal) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            temp.addAll(leftVal);
            allVal.add(temp);
        }
        for (List<Integer> rightVal : nodeRightVal) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            temp.addAll(rightVal);
            allVal.add(temp);
        }
        return allVal;
    }

}
