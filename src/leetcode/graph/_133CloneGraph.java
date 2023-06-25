package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _133CloneGraph {
    public static void main(String[] args) {
        Node node = buildNodes();
        Node clonedNode = cloneGraph(node, new HashMap<Integer, Node>());
        System.out.println(clonedNode);
    }


    public static Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (null == node) {
            return node;
        }
        Node cloneNode = new Node(node.val);
        map.put(node.val, cloneNode);

        List<Node> nodeNeighbors = node.neighbors;
        for (Node nodeNeighbor : nodeNeighbors) {
            Node cloneNeighbor = null != map.get(nodeNeighbor.val) ? map.get(nodeNeighbor.val) : cloneGraph(nodeNeighbor, map);
            cloneNode.neighbors.add(cloneNeighbor);
        }
        return cloneNode;
    }


    private static Node buildNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        return node1;
    }

}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

