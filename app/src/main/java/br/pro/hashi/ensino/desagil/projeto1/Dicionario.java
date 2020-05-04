package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dicionario{
    private Translator translator;
    private String result;
    private String morseChar;
    private String charMorse;

    public Dicionario() {
        translator = new Translator();
        char[] nodes = new char[]{'e', 't', 'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o', 'h', 'v', 'f', '*', 'l', '*', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', '*', '*', '5', '4', '*', '3', '*', '*', '*', '2', '*', '*', '*', '*', '*', '*', '*', '1', '6', '*', '*', '*', '*', '*', '*', '*', '7', '*', '*', '*', '8', '*', '9', '0'};
        for (char r : nodes) {
            if (r != '*') {
                result = translator.charToMorse(r);
                charMorse += r + " => " + result + '\n';
                morseChar += result + " => " + r + '\n';
            }
        }
        charMorse = charMorse.replace("null", "");
        morseChar = morseChar.replace("null", "");
    }

    public String getDicCharMorse(){
        return charMorse;
    }


    public String getDicMorseChar(){
        return morseChar;
    }
}

