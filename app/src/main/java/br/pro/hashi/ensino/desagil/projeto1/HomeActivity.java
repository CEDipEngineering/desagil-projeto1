package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("FieldCanBeLocal")
public class HomeActivity extends AppCompatActivity {
    private Button buttonTranslator;
    private Button buttonDict;
    private Button buttonMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonDict = findViewById(R.id.dict);
        buttonTranslator = findViewById(R.id.translator);
        buttonMessages = findViewById(R.id.messages);

        this.buttonDict.setOnClickListener((view) -> {
            Intent intent = new Intent(HomeActivity.this, DictionaryActivity.class);
            startActivity(intent);
        });


        this.buttonTranslator.setOnClickListener((view) -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);

        });

        this.buttonMessages.setOnClickListener((view) -> {
        });

    }
}
