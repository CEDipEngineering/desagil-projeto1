package br.pro.hashi.ensino.desagil.projeto1;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class SearchTest {
    /*  Testes para validação da busca em largura.  */
    @Test
    public void ABLeft_treeSearch_ExpectsListOfCharacters() {
        Node root = new Node('a');
        root.setLeft(new Node('b'));
        Search searcher = new Search(root);
        LinkedList<Character> expected = new LinkedList<>();
        expected.add('a');
        expected.add('b');
        Assert.assertEquals (expected, searcher.getOrder());
    }

    @Test
    public void ABRight_treeSearch_ExpectsListOfCharacters() {
        Node root = new Node('a');
        root.setRight(new Node('b'));
        Search searcher = new Search(root);
        LinkedList<Character> expected = new LinkedList<>();
        expected.add('a');
        expected.add('b');
        Assert.assertEquals (expected, searcher.getOrder());
    }

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

    @Test
    public void ABCDEFG_treeSearch_ExpectsListOfCharacters2() {
        Node root = new Node('a');
        root.setLeft(new Node('b'));
        root.setRight(new Node('c'));
        root.getLeft().setLeft(new Node('d'));
        root.getLeft().setRight(new Node('e'));
        root.getLeft().getLeft().setLeft(new Node('f'));
        root.getLeft().getLeft().setRight(new Node('g'));
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

    @Test
    public void ABGCEDF_treeSearch_ExpectsListOfCharacters() {
        Node root = new Node('a');
        root.setLeft(new Node('b'));
        root.setRight(new Node('g'));
        root.getLeft().setLeft(new Node('c'));
        root.getLeft().setRight(new Node('e'));
        root.getLeft().getLeft().setLeft(new Node('d'));
        root.getLeft().getLeft().setRight(new Node('f'));
        Search searcher = new Search(root);
        LinkedList<Character> expected = new LinkedList<>();
        expected.add('a');
        expected.add('b');
        expected.add('g');
        expected.add('c');
        expected.add('e');
        expected.add('d');
        expected.add('f');
        Assert.assertEquals (expected, searcher.getOrder());
    }

    @Test
    public void GFEDCBA_treeSearch_ExpectsListOfCharacters2() {
        Node root = new Node('g');
        root.setLeft(new Node('f'));
        root.setRight(new Node('e'));
        root.getLeft().setLeft(new Node('d'));
        root.getLeft().setRight(new Node('c'));
        root.getLeft().getLeft().setLeft(new Node('b'));
        root.getLeft().getRight().setRight(new Node('a'));
        Search searcher = new Search(root);
        LinkedList<Character> expected = new LinkedList<>();
        expected.add('g');
        expected.add('f');
        expected.add('e');
        expected.add('d');
        expected.add('c');
        expected.add('b');
        expected.add('a');
        Assert.assertEquals (expected, searcher.getOrder());
    }
}
