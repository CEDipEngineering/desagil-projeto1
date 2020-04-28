package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Translator translator = new Translator(); //protected quando tiverem mais activities?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        EditText editText = findViewById(R.id.edit_text);
        Button buttonPonto = findViewById(R.id.button_ponto);
        Button buttonTraco = findViewById(R.id.button_traço);

        buttonPonto.setOnClickListener((view) -> {
            String current = editText.getText().toString();
            current += '.';
            editText.setText(current);
            String updating = editText.getText().toString();
            String morse = Character.toString(this.translator.morseToChar(updating));
            text.setText(morse);
            System.out.println(updating);
        });

        buttonTraco.setOnClickListener((view) -> {
            String current = editText.getText().toString();
            current += '-';
            editText.setText(current);
            String updating = editText.getText().toString();
            String morse = Character.toString(this.translator.morseToChar(updating));
            text.setText(morse);
            System.out.println(updating);
        });
    }
}
