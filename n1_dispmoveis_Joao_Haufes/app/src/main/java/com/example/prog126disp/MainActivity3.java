package com.example.prog126disp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity3 extends ListActivity {

    String cores[] = new String[]{"Calcular", "Checkbox", "Tela 3", "Tela 4"};
    ArrayAdapter<String> meuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        meuAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, cores
        );

        setListAdapter(meuAdapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent mudaTela;

        switch (position) {
            case 0:
                mudaTela = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(mudaTela);
                finish();
                break;
            case 1:
                mudaTela = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(mudaTela);
                finish();
                break;
            case 2:
                Toast.makeText(this, "Tela 3", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Tela 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}