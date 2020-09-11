package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.HashMap;

public class PerfilHeroe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_heroe);
        Bundle bundleR=getIntent().getExtras();
        TextView tvSup=findViewById(R.id.tv_sup);
        TextView tvNombre=findViewById(R.id.tv_nombre);
        SuperHeroe superHeroe=(SuperHeroe)bundleR.getSerializable("Superheroes");
        tvSup.setText(tvSup.getText()+" "+superHeroe.nombre);
        tvNombre.setText(tvNombre.getText()+" "+superHeroe.alterego);
        HashMap habilidades=superHeroe.habilidades;
        int inteligencia=Integer.parseInt(habilidades.get("Inteligencia").toString());
        int fuerza=Integer.parseInt(habilidades.get("Fuerza").toString());
        int durabilidad=Integer.parseInt(habilidades.get("Durabilidad").toString());
        int velocidad=Integer.parseInt(habilidades.get("Velocidad").toString());
        int poder=Integer.parseInt(habilidades.get("Poder").toString());
        int combate=Integer.parseInt(habilidades.get("Combate").toString());
        BarChart barChart=findViewById(R.id.BarChart);
        ArrayList <BarEntry> datos=new ArrayList<>();
        datos.add(new BarEntry(1,inteligencia));
        datos.add(new BarEntry(2,fuerza));
        datos.add(new BarEntry(3,durabilidad));
        datos.add(new BarEntry(4,velocidad));
        datos.add(new BarEntry(5,poder));
        datos.add(new BarEntry(6,combate));
        BarDataSet barDataSet=new BarDataSet(datos,"Estadisticas");
        BarData barData=new BarData(barDataSet);
        barChart.setData(barData);
    }
}