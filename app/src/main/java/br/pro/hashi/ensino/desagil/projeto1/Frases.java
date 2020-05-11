package br.pro.hashi.ensino.desagil.projeto1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Frases {
    private ArrayList<String> prontas = new ArrayList<>();
    FileWriter writer;

    public void Frases(){
//        prontas.add("estou com saudades");
//        prontas.add("preciso ir ao banheiro");
//        prontas.add("estou com fome");
//        prontas.add("quero dar uma volta");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("prontas.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            prontas.add(line);
        }
    }

    private ArrayList<String> getMsg(){
        return prontas;
    }

    private void addMsg(String mensagem){
        prontas.add(mensagem);
    }
    private void saveArrayList(){
        {
            try {
                writer = new FileWriter("prontas.txt");

                for (String str : prontas) {
                    writer.write(str + System.lineSeparator());
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
