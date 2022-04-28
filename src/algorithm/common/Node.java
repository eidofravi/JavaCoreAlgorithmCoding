package algorithm.common;

public class Node {

    public Node right;
    public Node down;
    public Node diagonal;
    public int value;

    public Node(Node right, Node down, Node diagonal, int value) {
        this.right = right;
        this.down = down;
        this.diagonal = diagonal;
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

}
