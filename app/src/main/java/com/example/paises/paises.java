package com.example.paises;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class paises {
    //private final JSONArray datos = new JSONArray();
    String Nombre, imgPais;
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getimgPais() {
        return imgPais;
    }

    public void setimgPais(String imgPais) {
        imgPais = imgPais;
    }


    public paises(String codigoPais,JSONObject a) throws JSONException {
        Nombre =  a.getString("Name").toString();
        imgPais= "http://www.geognos.com/api/en/countries/flag/" +
                codigoPais + ".png";
    }

    public static ArrayList<paises> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<paises> lstpaises = new ArrayList<>();
        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String codigoPais = keys.next();
            JSONObject a = datos.getJSONObject(codigoPais);
            lstpaises.add(new paises(codigoPais, a));

        }
            return lstpaises;

        }
    }

