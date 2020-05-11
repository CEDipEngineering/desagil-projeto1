package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class DictionaryActivity extends AppCompatActivity {
    private static final Dicionario dictionary = new Dicionario();
    private Button homeButton;
    private Button dicButton;
    TextView textDicionario1;
    TextView textDicionario2;
    TextView textDicionario3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);
        homeButton = findViewById(R.id.home_button);
        dicButton = findViewById(R.id.troca_dic);

        textDicionario1 = findViewById(R.id.textDic1);
        textDicionario2 = findViewById(R.id.textDic2);
        textDicionario3 = findViewById(R.id.textDic3);
        textDicionario1.setText(dictionary.getDicMorseChar1());
        textDicionario2.setText(dictionary.getDicMorseChar2());
        textDicionario3.setText(dictionary.getDicMorseChar3());

        this.homeButton.setOnClickListener((view) -> {
            Intent intent = new Intent(DictionaryActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        this.dicButton.setOnClickListener((view) -> {
            if (dictionary.isState()) {
                textDicionario1.setText(dictionary.getDicCharMorse1());
                textDicionario2.setText(dictionary.getDicCharMorse2());
                textDicionario3.setText(dictionary.getDicCharMorse3());
                dicButton.setText(".-    =>    A"); //Traduz de Morse
            } else {
                textDicionario1.setText(dictionary.getDicMorseChar1());
                textDicionario2.setText(dictionary.getDicMorseChar2());
                textDicionario3.setText(dictionary.getDicMorseChar3());
                dicButton.setText("A    =>    .-"); //Traduz para Morse
            }
        });
    }
}
