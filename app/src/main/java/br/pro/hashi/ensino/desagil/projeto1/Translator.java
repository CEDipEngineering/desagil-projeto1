/*
 * NÃO É PERMITIDO MODIFICAR NADA NESTE ARQUIVO,
 * EXCETO PELO CONSTRUTOR E OS MÉTODOS INDICADOS.
 */

package br.pro.hashi.ensino.desagil.projeto1;

import java.util.HashMap;
import java.util.LinkedList;

public class Translator {
    private Node root;
    private HashMap<Character, Node> map;
    private char nos [];


    // Você deve mudar o recheio do construtor,
    // de acordo com os requisitos do projeto.
    public Node Translator(char[] arr, Node parent, Node current, int i, HashMap<Character, Node> map) {
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            current = temp;

            current.setParent(parent);

            // insert left child
            current.setLeft(Translator(arr, current, current.getLeft(),
                    2 * i + 1, map));

            // insert right child
            current.setRight(Translator(arr, current, current.getRight(),
                    2 * i + 2, map));


            map.put(current.getValue(), current);
        }


        return current;

    }
        // Você deve mudar o recheio deste método,
        // de acordo com os requisitos do projeto.
        public char morseToChar (String code){
            return ' ';
        }


        // Você deve mudar o recheio deste método,
        // de acordo com os requisitos do projeto.
        private String charToMorse (Node node){
            return " ";
        }


        // Este método deve permanecer como está.
        public String charToMorse ( char c){
            return charToMorse(map.get(c));
        }


        // Você deve mudar o recheio deste método,
        // de acordo com os requisitos do projeto.
        public LinkedList<String> getCodes () {
            return new LinkedList<>();
        }

}

//Para criar o Hashmap da arvore:
//Translator translator = new Translator();
//char[] nos = new char[]{'@','e','t','i','a','n','m','s','u','r','w','d','k','g','o','h','v','f','*','l','*','p','j','b','x','c','y','z','q','*','*','5','4','*','3','*','*','*','2','*','*','+','*','*','*','*','1','6','=','/','*','*','*','*','*','7','*','*','*','8','*','9','0'};
//t2.root = t2.Translator(nos, null, t2.root, 0, map);