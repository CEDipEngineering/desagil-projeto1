package br.pro.hashi.ensino.desagil.projeto1;

@SuppressWarnings("StringConcatenationInLoop")
class Dicionario {
    private String morseChar1;
    private String morseChar2;
    private String morseChar3;
    private String charMorse1;
    private String charMorse2;
    private String charMorse3;
    private boolean state;

    public Dicionario() {
        Translator translator = new Translator();
        char[] nodes = new char[]{'e', 't', 'i', 'a', 'n', 'm', 's', 'u', 'r', 'w', 'd', 'k', 'g', 'o', 'h', 'v', 'f', '*', 'l', '*', 'p', 'j', 'b', 'x', 'c', 'y', 'z', 'q', '*', '*', '5', '4', '*', '3', '*', '*', '*', '2', '*', '*', '*', '*', '*', '*', '*', '1', '6', '*', '*', '*', '*', '*', '*', '*', '7', '*', '*', '*', '8', '*', '9', '0'};
        char[] alfabetico = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String result;
        for (char r : nodes) {
            if (r != '*') {
                result = translator.charToMorse(r);
                morseChar1 += result + '\n';
                morseChar2 += "   =>   " + '\n';
                morseChar3 += String.valueOf(r) + '\n';
            }
        }
        for (char r : alfabetico) {
            result = translator.charToMorse(r);
            charMorse1 += String.valueOf(r) + '\n';
            charMorse2 += "   =>   " + '\n';
            charMorse3 += result + '\n';
        }
        charMorse1 = charMorse1.replace("null", "");
        charMorse2 = charMorse2.replace("null", "");
        charMorse3 = charMorse3.replace("null", "");
        morseChar1 = morseChar1.replace("null", "");
        morseChar2 = morseChar2.replace("null", "");
        morseChar3 = morseChar3.replace("null", "");

        state = false;
    }

    public String getDicCharMorse1() {
        state = false;
        return charMorse1;
    }

    public String getDicCharMorse2() {
        state = false;
        return charMorse2;
    }

    public String getDicCharMorse3() {
        state = false;
        return charMorse3;
    }

    public String getDicMorseChar1() {
        state = true;
        return morseChar1;
    }


    public String getDicMorseChar2() {
        state = true;
        return morseChar2;
    }


    public String getDicMorseChar3() {
        state = true;
        return morseChar3;
    }

    public boolean isState() {
        return state;
    }
}

