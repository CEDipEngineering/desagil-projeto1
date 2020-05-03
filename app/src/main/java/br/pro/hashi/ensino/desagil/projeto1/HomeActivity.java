package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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

        // Write dot if short click;
        this.buttonDict.setOnClickListener((view) -> {
            Intent intent=new Intent(HomeActivity.this,Dicionario.class);
            startActivity(intent);
        });

        // Write dash if long click;
        this.buttonTranslator.setOnClickListener((view) -> {
            Intent intent=new Intent(HomeActivity.this,MainActivity.class);
            startActivity(intent);

        });

        // Delete last signal, (or character if no signal present);
        this.buttonMessages.setOnClickListener((view) -> {


        });

    }
}
