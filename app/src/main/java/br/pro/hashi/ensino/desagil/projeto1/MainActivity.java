package br.pro.hashi.ensino.desagil.projeto1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;


@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity {
    private static final Translator translator = new Translator(); //protected quando tiverem mais activities?
    private final LinkedList<Character> outputChars = new LinkedList<>();
    private TextView text;
    private TextView textWord;
    private TextView editText;
    private Button buttonMorse;
    private Button buttonDelete;
    private Button buttonEndChar;
    private Button homeButton;
    private Button SMSButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textLetter);
        textWord = findViewById(R.id.textWord);
        editText = findViewById(R.id.edit_text);
        buttonMorse = findViewById(R.id.button_morse);
        buttonDelete = findViewById(R.id.button_delete);
        buttonEndChar = findViewById(R.id.button_endChar);
        homeButton = findViewById(R.id.home_button);
        SMSButton = findViewById(R.id.button_SMS);
        Intent myIntent = getIntent();
        // Try to get message handed in when creating intent
        String message = myIntent.getStringExtra("message");

        // If there is one, put it in the textView
        if (message != null) {
            textWord.setText(message);
            outputChars.clear();
            for (char c : message.toCharArray()) {
                outputChars.add(c);
            }
            update();
        }


        // Write dot if short click;
        this.buttonMorse.setOnClickListener((view) -> {
            writeDot();
            update();
        });

        // Write dash if long click;
        this.buttonMorse.setOnLongClickListener((view) -> {
            writeDash();
            update();
            // Has to return true to say that the longClick has been dealt with;
            return true;
        });

        // Delete last signal, (or character if no signal present);
        this.buttonDelete.setOnClickListener((view) -> {
            deleteMorse();
            update();
        });

        // Clear everything if long click on delete button;
        this.buttonDelete.setOnLongClickListener((view) -> {
            clearMsg();
            update();
            // Has to return true to say that the longClick has been dealt with;
            return true;
        });

        // End character, (or write space if no signal present);
        this.buttonEndChar.setOnClickListener((view) -> {
            endChar();
            update();
        });

        this.homeButton.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        this.SMSButton.setOnClickListener((view) -> {
            Intent intent = new Intent(MainActivity.this, SMSActivity.class);
            StringBuilder outMessage = new StringBuilder();
            for (char c : outputChars) {
                outMessage.append(c);
            }
            intent.putExtra("message", outMessage.toString());
            startActivity(intent);
        });
    }


    // Auxilary methods for OnCreate to function accordingly.

    private void update() {

        // Try to translate editText
        String morse = editText.getText().toString();
        String character = "Letra: ";
        if (translator.morseToChar(morse) != '*') {
            character += Character.toString(translator.morseToChar(morse));
        }
        text.setText(character);
        // Now to try and write the whole output string
        StringBuilder outputText = new StringBuilder("Mensagem: ");
        for (char c : outputChars) {
            outputText.append(c);
        }
        textWord.setText(outputText.toString());
    }

    private void writeDash() {
        String current = editText.getText().toString();
        current += '-';
        editText.setText(current);
    }

    private void writeDot() {
        String current = editText.getText().toString();
        current += '.';
        editText.setText(current);
    }

    private void deleteMorse() {
        String current = editText.getText().toString();
        // If signal is not empty, delete last character
        if (current.length() > 0) {
            current = current.substring(0, current.length() - 1);
            editText.setText(current);

            // Otherwise, delete last character typed
        } else if (outputChars.size() > 0) {
            outputChars.removeLast();
        }
    }

    private void endChar() {
        String current = editText.getText().toString();
        if (current.length() != 0) {
            outputChars.add(translator.morseToChar(editText.getText().toString()));
            editText.setText("");
        } else {
            outputChars.add(' ');
        }
    }

    @SuppressLint("SetTextI18n")
    private void clearMsg() {
        text.setText("Letra: ");
        textWord.setText("Mensagem: ");
        editText.setText("");
        // clear() method of LinkedList empties it;
        outputChars.clear();
    }
}
