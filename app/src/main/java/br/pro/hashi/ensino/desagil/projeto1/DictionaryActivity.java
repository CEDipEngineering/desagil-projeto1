package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity {
    private static Dicionario dictionary = new Dicionario();
    private Button homeButton;
    private Button dicButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);
        homeButton = findViewById(R.id.home_button);
        dicButton = findViewById(R.id.troca_dic);

        TextView textDicionario = findViewById(R.id.textDic);
        textDicionario.setText(dictionary.getDicMorseChar());

        this.homeButton.setOnClickListener((view) -> {
            Intent intent=new Intent(DictionaryActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        this.dicButton.setOnClickListener((view) -> {
            if (dictionary.isState()) {
                textDicionario.setText(dictionary.getDicCharMorse());
                dicButton.setText(".-   =>   A"); //Traduz de Morse
            } else {
                textDicionario.setText(dictionary.getDicMorseChar());
                dicButton.setText("A   =>   .-"); //Traduz para Morse
            }
        });
    }
}
