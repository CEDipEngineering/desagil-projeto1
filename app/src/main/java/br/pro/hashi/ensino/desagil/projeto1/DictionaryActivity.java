package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

@SuppressWarnings("FieldCanBeLocal")
public class DictionaryActivity extends AppCompatActivity {
    private static final Dicionario dictionary = new Dicionario();
    private Button homeButton;
    private Button dicButton;
    private TextView textDicionario1;
    private TextView textDicionario3;
    private ListView listDicionario1;
    private ListView listDicionario2;

    ArrayAdapter<String> dictadapter1;
    ArrayAdapter<String> dictadapter2;


    private LinkedList<String> listDict1;
    private LinkedList<String> listDict2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);
        homeButton = findViewById(R.id.home_button);
        dicButton = findViewById(R.id.troca_dic);

        //textDicionario1 = findViewById(R.id.textDic1);
        //textDicionario3 = findViewById(R.id.textDic3);

        listDicionario1 = findViewById(R.id.listDic1);
        listDicionario2 = findViewById(R.id.listDic3);

        listDict1 = dictionary.getMorseCharList1();
        listDict2 = dictionary.getMorseCharList2();

        this.setAdapters();

        //textDicionario1.setText(dictionary.getDicMorseChar1());
        //textDicionario3.setText(dictionary.getDicMorseChar3());

        this.homeButton.setOnClickListener((view) -> {
            Intent intent = new Intent(DictionaryActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        this.dicButton.setOnClickListener((view) -> {
            if (dictionary.isState()) {
                //textDicionario1.setText(dictionary.getDicCharMorse1());
                //textDicionario3.setText(dictionary.getDicCharMorse3());
                dicButton.setText(".-    =>    A"); //Traduz de Morse

                listDict1 = dictionary.getCharMorseList1();
                listDict2 = dictionary.getCharMorseList2();

                this.setAdapters();
            } else {
                //textDicionario1.setText(dictionary.getDicMorseChar1());
                //textDicionario3.setText(dictionary.getDicMorseChar3());
                dicButton.setText("A    =>    .-"); //Traduz para Morse

                listDict1 = dictionary.getMorseCharList1();
                listDict2 = dictionary.getMorseCharList2();

                this.setAdapters();
            }
        });
    }

    private void setAdapters() {
        dictadapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,listDict1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position,convertView,parent);


                // Change the item text size
                item.setTextSize(30);

                // return the view
                return item;
            }
        };
        dictadapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,listDict2){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position,convertView,parent);


                // Change the item text size
                item.setTextSize(30);

                // return the view
                return item;
            }
        };
        listDicionario1.setAdapter(dictadapter1);
        listDicionario2.setAdapter(dictadapter2);
    }

}
