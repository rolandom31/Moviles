package itesm.mx.aa0816442_p1_android_feb18;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Rolando on 15/02/18.
 */

public class Carrito extends AppCompatActivity implements AdapterView.OnItemLongClickListener, View.OnClickListener {
    ArrayList<Libro> arrayListLibro;
    LibroAdapter adapterLibros;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Libros en el carrito");

        //Toolbar
        Drawable backArrow = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back);
        toolbar.setNavigationIcon(backArrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });;

        ListView listaCarrito = (ListView) findViewById(R.id.listCarrito);
        Button btnTotal = (Button) findViewById(R.id.button_total);
        TextView mensaje = (TextView) findViewById(R.id.text_consejo);

        arrayListLibro = ((General)this.getApplication()).getArrayLibro();

        if (arrayListLibro.isEmpty()){
            mensaje.setText("No hay nada en el carrito");
        }
        adapterLibros = new LibroAdapter(this, arrayListLibro);
        listaCarrito.setOnItemLongClickListener(this);
        btnTotal.setOnClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id){
        Libro toRemove = adapterLibros.getItem(position);
        adapterLibros.remove(toRemove);
        adapterLibros.notifyDataSetChanged();
        return true;
    }

    @Override
    public void onClick(View view){
        double total = 0.00;
        for(Libro libro:arrayListLibro){
            total += libro.getPrecio();
        }

        //Snackbar.make(view, "Su total es: $"+Double.toString(total), Snackbar.LENGTH_LONG).setAction("Action", null).show();
        Toast.makeText(this,"Su total es: $"+Double.toString(total),Toast.LENGTH_LONG).show();
    }
}
