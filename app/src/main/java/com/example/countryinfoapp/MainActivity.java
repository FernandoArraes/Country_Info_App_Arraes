package com.example.countryinfoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paises.paises;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adaptadores.adaptador;
import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, Asynchtask{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);
        //zadaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Map<String, String> datos2 = new HashMap<String, String>();
        WebService ws= new WebService(
                " http://www.geognos.com/api/en/countries/info/all.json",
                datos2, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<paises> listapaises = new ArrayList<paises>();
        JSONObject response = new JSONObject(result);
        JSONObject resultsObject = response.getJSONObject("Results");
        listapaises = paises.JsonObjectsBuild(resultsObject);
        adaptador adaptadorPais = new adaptador(this, listapaises);
        ListView lstOpciones = (ListView) findViewById(R.id.lstpaises);
        lstOpciones.setAdapter(adaptadorPais);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}