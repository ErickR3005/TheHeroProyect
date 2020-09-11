package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buscarHeroe() {
    EditText nombre=findViewById(R.id.et_heroe);
    if (nombre.getText().toString().length()>=3){
        String url=" https://www.superheroapi.com/api.php/3612163438818253/search/"+nombre.getText().toString();
        System.out.println(url);
    }
    else{
        Toast.makeText(this,"Se requiere una longitud minima de 3 letras para buscar",Toast.LENGTH_SHORT).show();
        nombre.setText("");
    }
    }
    public void busqueda(View view){
        buscarHeroe();
    }
}