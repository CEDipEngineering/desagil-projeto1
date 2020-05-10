package br.pro.hashi.ensino.desagil.projeto1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;


//Código baseado de ExemploSMS da matéria Desenvolvimento Colaborativo Ágil
@SuppressWarnings("FieldCanBeLocal")
public class SMSActivity extends AppCompatActivity {
    private static final Translator translator = new Translator(); //protected quando tiverem mais activities?
    private final LinkedList<Character> outputChars = new LinkedList<>();
    private static final char[] numeros = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private TextView currentNumber, morseDisplay, messageDisplay, phoneDisplay;
    private Button buttonBack, buttonMorse, buttonDelete, buttonEndChar, buttonSMS;

    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s);

        // Carregar os views
        currentNumber = findViewById(R.id.current_number);
        morseDisplay = findViewById(R.id.morse_display);
        messageDisplay = findViewById(R.id.message_display);
        phoneDisplay = findViewById(R.id.phone_display);

        buttonBack = findViewById(R.id.button_back);
        buttonMorse = findViewById(R.id.button_morse);
        buttonDelete = findViewById(R.id.button_delete);
        buttonEndChar = findViewById(R.id.button_endChar);
        buttonSMS = findViewById(R.id.button_SMS);


        // Usa a mensagem que foi enviada junto da criação do intent para mostrar o que será enviado
        Intent myIntent = getIntent();
        String message = myIntent.getStringExtra("message");
        messageDisplay.setText("Mensagem: " + message);

        this.buttonBack.setOnClickListener((view) -> {
            Intent intent = new Intent(SMSActivity.this, MainActivity.class);
            intent.putExtra("message", message);
            startActivity(intent);
        });

        // Write dot if short click;
        this.buttonMorse.setOnClickListener((view) -> {
            writeDot();
            update();
        });

        // Write dash if long click;
        this.buttonMorse.setOnLongClickListener((view) -> {
            writeDash();
            update();
            // Has to return true to say that the longClick has been dealt with;
            return true;
        });

        // Delete last signal, (or character if no signal present);
        this.buttonDelete.setOnClickListener((view) -> {
            deleteMorse();
            update();


        });

        // Clear everything if long click on delete button;
        this.buttonDelete.setOnLongClickListener((view) -> {
            clearMsg();
            update();
            // Has to return true to say that the longClick has been dealt with;
            return true;
        });

        // End character, (or write space if no signal present);
        this.buttonEndChar.setOnClickListener((view) -> {
            endChar();
            update();
        });

        // Envia a mensagem
        this.buttonSMS.setOnClickListener((view) -> {
            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            String phone = phoneDisplay.getText().toString();

            // Esta verificação do número de telefone é bem
            // rígida, pois exige até mesmo o código do país.
            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número inválido!");
                return;
            }

            // Enviar uma mensagem de SMS. Por simplicidade,
            // não estou verificando se foi mesmo enviada,
            // mas é possível fazer uma versão que verifica.
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

            // Limpar o campo para nenhum engraçadinho
            // ficar apertando o botão várias vezes.
            phoneDisplay.setText("");
        });
    }

    private void update() {

        // Try to translate editText
        String morse = morseDisplay.getText().toString();
        String character = "Número: ";
        if ((translator.morseToChar(morse) != '*' && this.isNumber(morse))) {
            character += Character.toString(translator.morseToChar(morse));
        }
        currentNumber.setText(character);

        // Now to try and write the whole output string
        StringBuilder outputText = new StringBuilder("Telefone: ");
        for (char c : outputChars) {
            outputText.append(c);
        }
        phoneDisplay.setText(outputText.toString());
    }

    private void writeDash() {
        String current = morseDisplay.getText().toString();
        current += '-';
        morseDisplay.setText(current);
    }

    private void writeDot() {
        String current = morseDisplay.getText().toString();
        current += '.';
        morseDisplay.setText(current);
    }

    private void deleteMorse() {
        String current = morseDisplay.getText().toString();
        // If signal is not empty, delete last character
        if (current.length() > 0) {
            current = current.substring(0, current.length() - 1);
            morseDisplay.setText(current);

            // Otherwise, delete last character typed
        } else if (outputChars.size() > 0) {
            outputChars.removeLast();
        }
    }

    private void endChar() {
        String current = morseDisplay.getText().toString();
        if (current.length() != 0) {
            char temp = translator.morseToChar(current);
            if (this.isNumber(temp)) {
                outputChars.add(temp);
            }
            morseDisplay.setText("");
        } else {
            outputChars.add(' ');
        }
    }

    private void clearMsg() {
        currentNumber.setText("Número: ");
        phoneDisplay.setText("Telefone: ");
        morseDisplay.setText("");
        // clear() method of LinkedList empties it;
        outputChars.clear();
    }

    private boolean isNumber(String code) {
        char candidato = translator.morseToChar(code);
        return isNumber(candidato);
    }

    //Overload
    private boolean isNumber(char c) {
        for (char n : numeros) {
            if (c == n) {
                return true;
            }
        }
        return false;
    }
}

