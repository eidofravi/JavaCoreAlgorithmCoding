package algorithm.graph;

import algorithm.common.Node;

import java.util.HashMap;
import java.util.Map;

public class FindShortestDistance2Optimized {

    /*logic
    Every Node say Node 60, should return path as 1. So whenevery Node 50 asked for the distance from Node 90 it should return 1
    private static int shortestPath(Node node) - when Node is Node 60, it should return to 1 to Node 50 or Node 30 whoever is calling this node */

    // 10, 20, 30
    //40, 50, 60
    //70, 80, 90
    public static void main(String[] args) {
        int arr[][] = {{10, 20, 30, 100},{40, 50, 60, 110},{70, 80, 90, 120}};
        Node root =BuildNodes.buildNodes(arr);
        long L1 = System.currentTimeMillis();
        //System.out.println(findPath(root, new HashMap()));
        System.out.println(shortestPath(root, new HashMap()));
        long L2 = System.currentTimeMillis();
        System.out.println("time taken " + (L2 - L1));
    }

    private static int shortestPath(Node node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        if (node.right == null && node.down == null && node.diagonal == null) {
            return 0;
        }
        if (null != map.get(node.value)) {
            return map.get(node.value);
        }
        int path = Math.min(Math.min(shortestPath(node.right, map) , shortestPath(node.down, map)) , shortestPath(node.diagonal, map));
        map.put(node.value, path + 1);
        return path + 1 ;
    }
}
