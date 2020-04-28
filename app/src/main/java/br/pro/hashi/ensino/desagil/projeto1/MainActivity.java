package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private static Translator translator = new Translator(); //protected quando tiverem mais activities?
    private LinkedList<Character> outputChars = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.textLetter);
        TextView textWord = findViewById(R.id.textWord);
        EditText editText = findViewById(R.id.edit_text);
        Button buttonPonto = findViewById(R.id.button_ponto);
        Button buttonTraco = findViewById(R.id.button_traço);
        Button buttonDelete = findViewById(R.id.button_delete);
        Button buttonEndChar = findViewById(R.id.button_endChar);

        buttonPonto.setOnClickListener((view) -> {
            String current = editText.getText().toString();
            current += '.';
            editText.setText(current);
            String updating = editText.getText().toString();
            String morse = Character.toString(this.translator.morseToChar(updating));
            text.setText(morse);
//            System.out.println(updating);
        });

        buttonTraco.setOnClickListener((view) -> {
            String current = editText.getText().toString();
            current += '-';
            editText.setText(current);
            String updating = editText.getText().toString();
            String morse = Character.toString(this.translator.morseToChar(updating));
            text.setText(morse);
//            System.out.println(updating);
        });

        buttonDelete.setOnClickListener((view) -> {
            String current = editText.getText().toString();
            if (current.length() > 0){
                current = current.substring(0,current.length()-1);
                editText.setText(current);
                String updating = editText.getText().toString();
                String morse = Character.toString(this.translator.morseToChar(updating));
                text.setText(morse);
                //      System.out.println(updating);
            } else {
                if (outputChars.size() >0){
                    outputChars.removeLast();
                    String outputText = "";
                    for (char c : outputChars){
                        outputText += c;
                    }
                    textWord.setText(outputText);
                }
                System.out.println("Para de apagar por favor");
            }

        });

        buttonEndChar.setOnClickListener((view) -> {
            String current = editText.getText().toString();
            if (current.length() != 0){
                outputChars.add(this.translator.morseToChar(editText.getText().toString()));
                editText.setText("");
            } else {
                outputChars.add(' ');
            }
            String updating = editText.getText().toString();
            String morse = Character.toString(this.translator.morseToChar(updating));
            text.setText(morse);
            String outputText = "";
            for (char c : outputChars){
                outputText += c;
            }
            textWord.setText(outputText);
//            System.out.println(updating);
        });
    }
}
