package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.countryinfoapp.R;
import com.example.paises.paises;

import java.util.ArrayList;

public class adaptador extends ArrayAdapter<paises> {
    public adaptador (Context context, ArrayList<paises> datos) {
        super(context, R.layout.ly1, datos);
    }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.ly1, null);

            TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
            lblNombre.setText(getItem(position).getNombre());
            ImageView imageView = (ImageView)item.findViewById(R.id.imgPais);
            Glide.with(this.getContext())
                    .load(getItem(position).getimgPais())
                    .into(imageView);
            return(item);





        }
}
