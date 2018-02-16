package itesm.mx.aa0816442_p1_android_feb18;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

/**
 * Created by Rolando on 15/02/18.
 */

public class Detalle extends AppCompatActivity implements View.OnClickListener {
    String isbn;
    String titulo;
    int idImagen;
    double precio;
    Libro libro;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        //Cambiar texto del toolbar
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detalle del libro");
        //agregar el icono para regresar
        Drawable backArrow = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back);
        toolbar.setNavigationIcon(backArrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     finish();
                                                 }
                                             }

        );

        TextView tvTitulo=(TextView) findViewById(R.id.text_valorTitulo);
        TextView tvIsbn=(TextView)findViewById(R.id.text_valorISBN);
        TextView tvPrecio=(TextView)findViewById(R.id.text_valorPrecio);
        ImageView ivLibro=(ImageView)findViewById(R.id.image_detalle);
        Button btnAceptar=(Button)findViewById(R.id.button_aceptar);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            isbn=intent.getStringExtra("isbn");
            titulo=intent.getStringExtra("titulo");
            precio=intent.getDoubleExtra("precio", 0.00);
            idImagen=intent.getIntExtra("imagen",R.mipmap.ic_launcher);

            libro= new Libro(titulo, isbn, precio, idImagen);

            String stPrecio=Double.toString(precio);

            tvTitulo.setText(titulo);
            tvIsbn.setText(isbn);
            tvPrecio.setText(stPrecio);

            Drawable drawable = ContextCompat.getDrawable(this, idImagen);
            ivLibro.setImageDrawable(drawable);

            btnAceptar.setOnClickListener(this);
        }


        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCarrito =new Intent(Detalle.this, Carrito.class);
                startActivity(intentCarrito);
            }
        });
    }

    @Override
    public void onClick(View view){
        General application = (General) this.getApplication();
        application.addLibro(libro);
        //Snackbar.make(view, titulo+"Agregado al carrito", Snackbar.LENGTH_LONG).setAction("Action",null).show();
        Toast.makeText(this, "Agregado al carrito", Toast.LENGTH_LONG).show();
    }
}
