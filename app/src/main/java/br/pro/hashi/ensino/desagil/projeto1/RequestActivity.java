package br.pro.hashi.ensino.desagil.projeto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

//Activity e XML baseados de https://github.com/hashiprobr/desagil-android-sms

public class RequestActivity extends AppCompatActivity {
    private static final int REQUEST_SEND_SMS = 0;
    private void startSMSActivity() {

        // Constrói uma Intent que corresponde ao pedido de "iniciar Activity".
        Intent intent = new Intent(RequestActivity.this, SMSActivity.class);
        Intent myIntent = getIntent();
        String outMessage = myIntent.getStringExtra("message");
        intent.putExtra("message", outMessage.toString());
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        System.out.println("CRIOU");
        Button buttonExample = findViewById(R.id.button_example);
        buttonExample.setOnClickListener((view) -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                startSMSActivity();
            } else {
                String[] permissions = new String[]{
                        Manifest.permission.SEND_SMS,
                };
                ActivityCompat.requestPermissions(this, permissions, REQUEST_SEND_SMS);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        System.out.print("ENTROUPERM");
        if (requestCode == REQUEST_SEND_SMS && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startSMSActivity();
        }else{
        }
    }
}