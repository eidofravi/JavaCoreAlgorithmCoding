package algorithm.graph;

import algorithm.common.Node;

import java.util.HashMap;
import java.util.Map;

public class BuildNodes {
    public static Node buildNodes(int[][] arr) {

        //arr[][] = {{10, 20, 30},{40, 50, 60},{70, 80, 90}};
        int rows = arr.length;
        int columns = arr[0].length;
        Node currentNode = null;
        Map<Integer, Node> nodeMap = new HashMap();
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = columns - 1; col >= 0; col--) {
                int colRight = col + 1;
                int rowDown = row + 1;
                Node rightNode = null;
                Node downNode = null;
                Node diagonalNode = null;
                if (colRight < columns) {
                    int rightValue = arr[row][colRight];
                    rightNode = nodeMap.get(rightValue);
                }
                if (rowDown < rows) {
                    int downValue = arr[rowDown][col];
                    downNode = nodeMap.get(downValue);
                }
                if (colRight < columns && rowDown < rows) {
                    int rightDownValue = arr[rowDown][colRight];
                    diagonalNode = nodeMap.get(rightDownValue);
                }
                currentNode = new Node(rightNode, downNode, diagonalNode, arr[row][col]);
                nodeMap.put(arr[row][col], currentNode);
            }
        }
        return currentNode;
    }

    public static Node buildNodes2() {
        Node node90 = new Node(90);
        Node node80 = new Node(node90, null, null, 80);
        Node node70 = new Node(node80, null, null, 70);

        Node node60 = new Node(null, node90, null, 60);
        Node node50 = new Node(node60, node80, node90, 50);
        Node node40 = new Node(node50, node70, node80, 40);

        Node node30 = new Node(null, node60, null, 30);
        Node node20 = new Node(node30, node50, node60, 20);
        Node root = new Node(node20, node40, node50, 10);
        return root;
    }

}
