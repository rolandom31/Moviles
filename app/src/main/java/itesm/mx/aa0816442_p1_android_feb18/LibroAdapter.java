package itesm.mx.aa0816442_p1_android_feb18;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rolando on 15/02/18.
 */

public class LibroAdapter extends ArrayAdapter<Libro> {
    public LibroAdapter (Context context, ArrayList<Libro> libros){
        super(context, 0, libros);
    }


    @Override
    public View getView (int position, View converView, ViewGroup parent){
        Libro libro = getItem(position);
        //convertview
        if(converView==null){
            converView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TextView tvTitulo= (TextView)converView.findViewById(R.id.text_titulo);
        TextView tvIsbn= (TextView)converView.findViewById(R.id.text_isbn);
        TextView tvPrecio=(TextView)converView.findViewById(R.id.text_precio);
        ImageView ivLibro= (ImageView)converView.findViewById(R.id.image_libro);

        tvTitulo.setText(libro.getTitulo());
        tvIsbn.setText(libro.getIsbn());
        String sPrecio = "$"+ Double.toString(libro.getPrecio());
        ivLibro.setImageResource(libro.getIdImagen());

        return converView;

    }
}
