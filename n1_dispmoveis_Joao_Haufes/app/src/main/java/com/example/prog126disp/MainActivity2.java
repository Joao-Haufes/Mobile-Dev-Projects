package com.example.prog126disp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity2 extends AppCompatActivity {

    private TextView editText1, resText;
    private Button bt1;
    private CheckBox checkBox1;
    Intent newIntent;
    private double resultSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText1 = findViewById(R.id.myTextView);
        bt1 = findViewById(R.id.myButton);
        checkBox1 = findViewById(R.id.myCheckBox);
        resText = findViewById(R.id.resultadoText);

        newIntent = getIntent();
        resultSum = (Double) newIntent.getSerializableExtra("resultadoSum");

        resText.setText(String.valueOf(resultSum));

        Log.e("Log.", "onCreate: Valor: " + resultSum);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked() == true) {
                    Intent mudaTela2 = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(mudaTela2);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Aceite os Termos!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}