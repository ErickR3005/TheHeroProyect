package com.example.theheroproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    ArrayList<SuperHeroe> superHeroes= new ArrayList<>();
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
    }

    public void buscarHeroe(View view) {

    nombre=findViewById(R.id.et_heroe);
    RequestQueue queue= Volley.newRequestQueue(getApplicationContext());

    if (nombre.getText().toString().length()>=3){
        String url="https://www.superheroapi.com/api.php/3612163438818253/search/"+nombre.getText().toString();
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray myJsonArray = response.getJSONArray("results");
                    for (int i=0;i<myJsonArray.length();i++){
                        JSONObject myObject=myJsonArray.getJSONObject(i);
                        String id=myObject.getString("id");
                        String alterego=myObject.getJSONObject("biography").getString("full-name");
                        String nombre=myObject.getString("name");
                        HashMap habilidades=new HashMap();
                        habilidades.put("Inteligencia",myObject.getJSONObject("powerstats").getString("intelligence"));
                        habilidades.put("Fuerza",myObject.getJSONObject("powerstats").getString("strength"));
                        habilidades.put("Velocidad",myObject.getJSONObject("powerstats").getString("speed"));
                        habilidades.put("Durabilidad",myObject.getJSONObject("powerstats").getString("durability"));
                        habilidades.put("Poder",myObject.getJSONObject("powerstats").getString("power"));
                        habilidades.put("Combate",myObject.getJSONObject("powerstats").getString("combat"));
                        SuperHeroe superHeroe=new SuperHeroe(id,alterego,nombre,habilidades);
                        superHeroes.add(superHeroe);
                        System.out.println(superHeroe);
                    }
                    Intent intent=new Intent(context,Resultados.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("Superheroes",superHeroes);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                } catch (JSONException e) {
                    System.out.println("Error "+e);
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("No entra ni por Dios ni por la patria "+error);
            }
        });
        queue.add(request);
    }
    else{
        Toast.makeText(this,"Se requiere una longitud minima de 3 letras para buscar",Toast.LENGTH_SHORT).show();
        nombre.setText("");
    }
    }

}