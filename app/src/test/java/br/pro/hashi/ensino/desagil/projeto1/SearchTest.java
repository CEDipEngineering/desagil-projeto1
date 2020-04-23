package br.pro.hashi.ensino.desagil.projeto1;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class SearchTest {
    /*  Testes para validação da busca em largura.  */
    @Test
    public void ABCDEFG_treeSearch_ExpectsListOfCharacters() {
        Node root = new Node('a');
        root.setLeft(new Node('b'));
        root.setRight(new Node('c'));
        root.getLeft().setLeft(new Node('d'));
        root.getLeft().setRight(new Node('e'));
        root.getRight().setLeft(new Node('f'));
        root.getRight().setRight(new Node('g'));
        Search searcher = new Search(root);
        LinkedList<Character> expected = new LinkedList<>();
        expected.add('a');
        expected.add('b');
        expected.add('c');
        expected.add('d');
        expected.add('e');
        expected.add('f');
        expected.add('g');
        Assert.assertEquals (expected, searcher.getOrder());
    }

}
