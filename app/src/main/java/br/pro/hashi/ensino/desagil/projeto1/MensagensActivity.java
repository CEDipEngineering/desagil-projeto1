package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.LinkedList;

public class MensagensActivity extends AppCompatActivity {
    private static Frases mensagens = new Frases();
    private Button msg1;
    private Button msg2;
    private Button msg3;
    private Button msg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);
        msg1 = findViewById(R.id.msg_1);
        msg2 = findViewById(R.id.msg_2);
        msg3 = findViewById(R.id.msg_3);
        msg4 = findViewById(R.id.msg_4);
    }



}

