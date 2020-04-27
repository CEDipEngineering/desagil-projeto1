package br.pro.hashi.ensino.desagil.projeto1;

import java.util.LinkedList;
import java.util.Queue;

public class Search {
    private final Queue<Node> queue;
    private final Node root;
    public Search(Node r) {
        this.root = r;
        queue = new LinkedList<>();
    }
    public LinkedList<Character> getOrder() {
        LinkedList<Character> outList = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node node = queue.element();
            Node left = node.getLeft();
            Node right = node.getRight();
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            outList.add(node.getValue());
            queue.remove();
        }
        return outList;
    }
}

