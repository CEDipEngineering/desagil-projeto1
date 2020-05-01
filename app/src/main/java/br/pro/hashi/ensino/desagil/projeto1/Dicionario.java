package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;
import br.pro.hashi.ensino.desagil.projeto1.Translator;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;

public class Dicionario extends AppCompatActivity {
    //private HashMap<Character, Node> map;
    private Translator translator;
    private String result;
    private String juncao;
    private String morses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);

        TextView dictionary = findViewById(R.id.Dictionary);
    }

    public Dicionario(){
        //map = new HashMap<Character, Node>();
        TextView dictionary = findViewById(R.id.Dictionary);
        translator = new Translator();
        char[] nodes = new char[]{'*', 'e', 't', 'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o', 'h', 'v', 'f', '*', 'l', '*', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', '*', '*', '5', '4', '*', '3', '*', '*', '*', '2', '*', '*', '*', '*', '*', '*', '*', '1', '6', '*', '*', '*', '*', '*', '*', '*', '7', '*', '*', '*', '8', '*', '9', '0'};
        for(char r : nodes){


            if (r != '*') {
                result = translator.charToMorse(r);
                juncao += r + " " + result + '\n';


            }

        }


        dictionary.setText(juncao);

    }


}
