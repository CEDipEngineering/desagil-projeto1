package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class MensagensActivity extends AppCompatActivity {

    private ListView listView;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);

        listView=(ListView)findViewById(R.id.listview);
        homeButton = findViewById(R.id.home_button);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Venha cá");
        arrayList.add("Estou precisando de ajuda");
        arrayList.add("É urgente!");
        arrayList.add("Venha ver isso");
        arrayList.add("Estou com sede");
        arrayList.add("A TV quebrou de novo");
        arrayList.add("Socorro");
        arrayList.add("Está chovendo?");
        arrayList.add("Tá passando o jogo?");
        arrayList.add("Acabou a cerveja");
        arrayList.add("Desliga a TV que o Bolsonaro começou a falar de novo");
        arrayList.add("Olha a campainha");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            Toast.makeText(MensagensActivity.this, "clicked item:"+i+" "+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MensagensActivity.this, MainActivity.class);
            intent.putExtra("message", arrayList.get(i).toString());
            startActivity(intent);
        }
        });



        this.homeButton.setOnClickListener((view) -> {
            Intent intent=new Intent(MensagensActivity.this, HomeActivity.class);
            startActivity(intent);
        });

    }

}
