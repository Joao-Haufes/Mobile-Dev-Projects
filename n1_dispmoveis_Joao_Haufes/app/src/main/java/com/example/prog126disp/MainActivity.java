package com.example.prog126disp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    private EditText number1, number2;
    private Button btSoma, btSubtrai, btMultiplica, btDivide, btAlteraTela;
    private ImageButton btVoltar;
    int n1, n2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSoma = findViewById(R.id.btSum);
        btSubtrai = findViewById(R.id.btSubt);
        btMultiplica = findViewById(R.id.btMult);
        btDivide = findViewById(R.id.btDiv);
        btVoltar = findViewById(R.id.btBack);
        text = findViewById(R.id.textHello);
        number1 = findViewById(R.id.editN1);
        number2 = findViewById(R.id.editN2);

        btSoma.setOnClickListener(this);
        btSubtrai.setOnClickListener(this);
        btMultiplica.setOnClickListener(this);
        btDivide.setOnClickListener(this);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mudaTelaInicial = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(mudaTelaInicial);
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int vControle = 0;

        if (!testaEditText(number1)) {
            if(!testaEditText(number2)) {
                number1.setError("Campo Obrigatório!");
                number2.setError("Campo Obrigatório!");
            } else {
                number1.setError("Campo Obrigatório!");
            }
        } else if (testaEditText(number2)) {

            n1 = Integer.parseInt(number1.getText().toString());
            n2 = Integer.parseInt(number2.getText().toString());

            switch (view.getId()) {
                case R.id.btSum:
                    result = n1 + n2;
                    break;
                case R.id.btSubt:
                    result = n1 - n2;
                    break;
                case R.id.btMult:
                    result = n1 * n2;
                    break;
                case R.id.btDiv:
                    if (n2 != 0) {
                        result = n1 / n2;
                        break;
                    } else {
                        vControle = 1;
                    }
            }

            if(vControle != 1) {
                Intent intentMudaTela = new Intent(MainActivity.this, MainActivity2.class);

                intentMudaTela.putExtra("resultadoSum", result);
                startActivity(intentMudaTela);
                finish();
            } else {
                number2.setError("Não é possível dividir por 0!");
            }
        } else {
            number2.setError("Campo Obrigatório!");
        }
    }
    public boolean testaEditText(EditText edt) {
        if (TextUtils.isEmpty(edt.getText().toString())) {
            return false;
        } else {
            return true;
        }
    }
}