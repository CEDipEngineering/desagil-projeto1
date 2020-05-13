package br.pro.hashi.ensino.desagil.projeto1;

import java.util.LinkedList;

@SuppressWarnings("StringConcatenationInLoop")
class Dicionario {
    private String morseChar1;
    private String morseChar3;
    private String charMorse1;
    private String charMorse3;
    private LinkedList<String> listMorseChar1;
    private LinkedList<String> listMorseChar2;
    private LinkedList<String> listCharMorse1;
    private LinkedList<String> listCharMorse2;
    private boolean state;

    public Dicionario() {
        Translator translator = new Translator();
        char[] nodes = new char[]{'e', 't', 'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o', 'h', 'v', 'f', '*', 'l', '*', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', '*', '*', '5', '4', '*', '3', '*', '*', '*', '2', '*', '*', '*', '*', '*', '*', '*', '1', '6', '*', '*', '*', '*', '*', '*', '*', '7', '*', '*', '*', '8', '*', '9', '0'};
        char[] alfabetico = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String result;

        listMorseChar1 = new LinkedList<>();
        listMorseChar2 = new LinkedList<>();
        listCharMorse1 = new LinkedList<>();
        listCharMorse2 = new LinkedList<>();

        for (char r : nodes) {
            if (r != '*') {
                result = translator.charToMorse(r);
                String morse = result;
                morse = morse.replace("null", "");
                String roman = String.valueOf(r);
                roman = roman.replace("null", "");
                if (morse != "") {
                    //morseChar1 += morse + '\n';
                    //morseChar3 += roman + '\n';
                    listMorseChar1.add(morse);
                    listMorseChar2.add(roman);
                }
            }
        }
        for (char r : alfabetico) {
            result = translator.charToMorse(r);
            String morse = result;
            morse = morse.replace("null", "");
            String roman = String.valueOf(r);
            roman = roman.replace("null", "");
            //charMorse1 += roman + '\n';
            //charMorse3 += morse + '\n';
            listCharMorse1.add(roman);
            listCharMorse2.add(morse);
        }
        //charMorse1 = charMorse1.replace("null", "");
        //charMorse3 = charMorse3.replace("null", "");
        //morseChar1 = morseChar1.replace("null", "");
        //morseChar3 = morseChar3.replace("null", "");

        state = false;
    }

    public String getDicCharMorse1() {
        state = false;
        return charMorse1;
    }


    public String getDicCharMorse3() {
        state = false;
        return charMorse3;
    }

    public String getDicMorseChar1() {
        state = true;
        return morseChar1;
    }



    public String getDicMorseChar3() {
        state = true;
        return morseChar3;
    }

    public LinkedList<String> getCharMorseList1() {
        state = false;
        return listCharMorse1;
    }

    public LinkedList<String> getCharMorseList2() {
        state = false;
        return listCharMorse2;
    }

    public LinkedList<String> getMorseCharList1() {
        state = true;
        return listMorseChar1;
    }

    public LinkedList<String> getMorseCharList2() {
        state = true;
        return listMorseChar2;
    }

    public boolean isState() {
        return state;
    }
}

