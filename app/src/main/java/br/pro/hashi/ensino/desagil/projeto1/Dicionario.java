package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dicionario{
    private Translator translator;
    private String result;
    private String morseChar;
    private String charMorse;
    private boolean state;

    public Dicionario() {
        translator = new Translator();
        char[] nodes = new char[]{'e', 't', 'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o', 'h', 'v', 'f', '*', 'l', '*', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', '*', '*', '5', '4', '*', '3', '*', '*', '*', '2', '*', '*', '*', '*', '*', '*', '*', '1', '6', '*', '*', '*', '*', '*', '*', '*', '7', '*', '*', '*', '8', '*', '9', '0'};
        char[] alfabetico = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        for (char r : nodes) {
            if (r != '*') {
                result = translator.charToMorse(r);
                morseChar += result + "   =>   " + r + '\n';
            }
        }
        for (char r : alfabetico) {
            result = translator.charToMorse(r);
            charMorse += r + "   =>   " + result + '\n';
        }
        charMorse = charMorse.replace("null", "");
        morseChar = morseChar.replace("null", "");

        state = false;
    }

    public String getDicCharMorse(){
        state = false;
        return charMorse;
    }


    public String getDicMorseChar(){
        state = true;
        return morseChar;
    }

    public boolean isState() {
        return state;
    }
}

