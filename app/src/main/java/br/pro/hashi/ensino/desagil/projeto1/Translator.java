/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    private Node root;
    private final HashMap<Character, Node> map;


    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.

    public Translator() {
        // noinspection Convert2Diamond
        map = new HashMap<Character, Node>();
        char[] nodes = new char[]{'*', 'e', 't', 'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o', 'h', 'v', 'f', '*', 'l', '*', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', '*', '*', '5', '4', '*', '3', '*', '*', '*', '2', '*', '*', '*', '*', '*', '*', '*', '1', '6', '*', '*', '*', '*', '*', '*', '*', '7', '*', '*', '*', '8', '*', '9', '0'};
        this.root = this.createTree(nodes, null, this.root, 0, map);
    }

    // Código baseado em https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
    private Node createTree(char[] arr, Node parent, Node current, int i, HashMap<Character, Node> map) {
        if (i < arr.length) {
            current = new Node(arr[i]);

            current.setParent(parent);

            // insert left child
            current.setLeft(this.createTree(arr, current, current.getLeft(),
                    2 * i + 1, map));

            // insert right child
            current.setRight(this.createTree(arr, current, current.getRight(),
                    2 * i + 2, map));


            map.put(current.getValue(), current);
        }


        return current;

    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public char morseToChar(String code) {
        Node temp = this.root;
        if (code.length() <= 5) {
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == '-') {
                    temp = temp.getRight();
                } else if (code.charAt(i) == '.') {
                    temp = temp.getLeft();
                }
            }
        }
        return temp.getValue();
    }

    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    private String charToMorse(Node node) {
        StringBuilder morse = new StringBuilder();
        Node original = node;
        Node temp;
        while (original.getParent() != null) {
            temp = original.getParent();
            if (temp.getLeft() == original) {
                morse.append(".");
            } else {
                morse.append("-");
            }
            original = original.getParent();
        }


        return new StringBuilder(morse.toString()).reverse().toString();
    }


    // Este método deve permanecer como está.
    public String charToMorse(char c) {
        return charToMorse(map.get(c));
    }


    // Você deve mudar o recheio deste método,
    // de acordo com os requisitos do projeto.
    public LinkedList<String> getCodes() {
        Search search = new Search(this.root);
        LinkedList<Character> resultadoBusca = search.getOrder();
        LinkedList<String> outputList = new LinkedList<>();
        for (char c : resultadoBusca) {
            if (c != '*') {
                outputList.add(this.charToMorse(c));
            }
        }
        System.out.println(outputList);
        return outputList;
    }

}

