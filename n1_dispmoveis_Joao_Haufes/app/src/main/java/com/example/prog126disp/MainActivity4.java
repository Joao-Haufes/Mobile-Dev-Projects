package com.example.prog126disp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity4 extends AppCompatActivity {

    CheckBox chk1, chk2, chk3, chk4;
    Button btConcordar;
    ImageButton btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        chk1 = findViewById(R.id.box1);
        chk2 = findViewById(R.id.box2);
        chk3 = findViewById(R.id.box3);
        chk4 = findViewById(R.id.box4);
        btConcordar = findViewById(R.id.button);
        btVoltar = findViewById(R.id.btBack2);

        btConcordar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Checkbox 1 Marcada!", Toast.LENGTH_SHORT).show();
                }
                if (chk2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Checkbox 2 Marcada!", Toast.LENGTH_SHORT).show();
                }
                if (chk3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Checkbox 3 Marcada!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mudaTelaInicial = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(mudaTelaInicial);
                finish();
            }
        });
    }
}