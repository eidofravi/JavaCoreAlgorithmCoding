package algorithm.graph;

import algorithm.common.Node;

import java.util.HashMap;
import java.util.Map;

public class FindShortestDistance {

    public static void main(String[] args) {
        Node node90 = new Node(90);
        Node node80 = new Node(node90, null, null, 80);
        Node node70 = new Node(node80, null, null, 70);

        Node node60 = new Node(null, node90, null, 60);
        Node node50 = new Node(node60, node80, node90, 50);
        Node node40 = new Node(node50, node70, node80, 40);

        Node node30 = new Node(null, node60, null, 30);
        Node node20 = new Node(node30, node50, node60, 20);
        Node root = new Node(node20, node40, node50, 10);
        System.out.println(findShortest(root, new HashMap<>()));
    }

    public static int findShortest(Node node, Map<Integer, Integer> map) {
        Integer minRight = null, minDown = null, minDiagonal = null;
        int min = Integer.MAX_VALUE;
        if (null != map.get(node.value)) {
            return map.get(node.value);
        }
        if (null == node.right && null == node.down && null == node.diagonal) {
            return 0;
        }
        if (null != node.right) {
            minRight = findShortest(node.right, map) + 1;
            min = Math.min(min, minRight);
        }
        if (null != node.down) {
            minDown = findShortest(node.down, map) + 1;
            min = Math.min(min, minDown);
        }
        if (null != node.diagonal) {
            minDiagonal = findShortest(node.diagonal, map) + 1;
            min = Math.min(min, minDiagonal);
        }

        System.out.println("node value " + node.value + " value " + min);
        map.put(node.value, min);
        return min;

    }
}
