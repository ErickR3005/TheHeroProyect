package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    ListView listView;
    ArrayList<SuperHeroe>s= new ArrayList<>();
    ArrayList<String>info=new ArrayList<>();
    Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        listView=(ListView)findViewById(R.id.ListView);

        ArrayAdapter  adaptador= new ArrayAdapter(this,android.R.layout.simple_list_item_1,info);
        listView.setAdapter(adaptador);
        obtenerInfo();
        context=this;
        TextView tvResultado=findViewById(R.id.tv_resultado);
        tvResultado.setText(tvResultado.getText().toString()+" "+info.size());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(context,PerfilHeroe.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("Superheroes",s.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }
    public void Volver(View v){
        startActivity(new Intent(this,MainActivity.class));
        finish();
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