package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        EditText editText = findViewById(R.id.edit_text);
        Button buttonPonto = findViewById(R.id.button_ponto);
        Button buttonTraço = findViewById(R.id.button_traço);

        buttonPonto.setOnClickListener((view) -> {
            String content = editText.getText().toString();
            text.setText(content);
        });

        buttonTraço.setOnClickListener((view) -> {
            String content = editText.getText().toString();
            text.setText(content);
        });
    }
}
