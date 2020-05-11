package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class MensagensActivity extends AppCompatActivity {
    private ListView listView;
//    private Frases frases = new Frases();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagens);

        listView=(ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        String text = "";
        try{
            InputStream inputStream = getAssets().open("prontas.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
            System.out.println(text);
            String lines[] = text.split("\\r?\\n");
            for (String line : lines) {
                arrayList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);
//        System.out.println(arrayList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MensagensActivity.this, "clicked item:"+i+" "+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}

