package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Resultados extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        listView=(ListView)findViewById(R.id.ListView);
    }
    public void Siguiente(View v){
        Intent intent=new Intent(this,SuperHeroe.class);
        startActivity(intent);
    }
}