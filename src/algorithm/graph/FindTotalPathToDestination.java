package algorithm.graph;

import algorithm.common.Node;

import java.util.HashMap;
import java.util.Map;

public class FindTotalPathToDestination {

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
        long L1 = System.currentTimeMillis();
        System.out.println(findPath(root, new HashMap()));
        long L2 = System.currentTimeMillis();
        System.out.println("time taken " + (L2 - L1));

    }

    private static int findPath(Node node, Map<Integer, Integer> map) {
        int sum = 0;
        if (null != map.get(node.value)) {
            return map.get(node.value);
        }

        if (null == node.right && null == node.down && null == node.diagonal) {
            System.out.println();
            return 1;
        }

        if (null != node.right) {
           // System.out.print(node.right.value + " ");
            sum += findPath(node.right, map);
        }
        if (null != node.down) {
           // System.out.print(node.down.value + " ");
            sum += findPath(node.down, map);
        }
        if (null != node.diagonal) {
           // System.out.print(node.diagonal.value + " ");
            sum += findPath(node.diagonal, map);
        }
        System.out.println("===" +  node.value);

        map.put(node.value, sum);

        return sum;
    }


}
