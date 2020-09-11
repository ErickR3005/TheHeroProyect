package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    ListView listView;
    ArrayList<SuperHeroe>s= new ArrayList<>();
    ArrayList<String>info=new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        listView=(ListView)findViewById(R.id.ListView);

        ArrayAdapter  adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,info);
        listView.setAdapter(adaptador);
        obtenerInfo();
        TextView tvResultado=findViewById(R.id.tv_resultado);
        tvResultado.setText(tvResultado.getText().toString()+" "+info.size());
    }
    public void Siguiente(View v){
        Intent intent=new Intent(this,SuperHeroe.class);
        startActivity(intent);
    }
    private void obtenerInfo(){
        Bundle objetoEnviado= getIntent().getExtras();
        if(objetoEnviado!=null){
            s= (ArrayList<SuperHeroe>) objetoEnviado.getSerializable("Superheroes");
        }
        obtenerLista();
    }
    private void obtenerLista(){
        for(SuperHeroe superHeroe:s){
            info.add(superHeroe.nombre);
        }
    }
}