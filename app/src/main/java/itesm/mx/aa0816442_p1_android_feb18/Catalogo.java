package itesm.mx.aa0816442_p1_android_feb18;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;


import java.util.ArrayList;

public class Catalogo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Libro> arrayListLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Extra Toolbar
        Drawable backArrow = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back);
        toolbar.setNavigationIcon(backArrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                finish();
            }
        });;

        arrayListLibro=getDataForListView();
        LibroAdapter adapterLibros =new LibroAdapter(this, arrayListLibro);
        GridView gridView=(GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapterLibros);

        gridView.setOnItemClickListener(this);

        /*/Floating button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCarrito= new Intent(Catalogo.this, Carrito.class);
            }
        });-->*/

        //Image button
        ImageButton fab=(ImageButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCarrito = new Intent(Catalogo.this, Carrito.class);
            }
        });
    }

    //inicializa lista de libros
    public ArrayList<Libro> getDataForListView() {
        Libro libro;

        ArrayList<Libro> listLibros = new ArrayList<Libro>();
        libro = new Libro("Introduction to Android Application Development: Android Essentials", "013438945X", 39.99, R.drawable.libro1);
        listLibros.add(libro);
        libro = new Libro("Android Application Development Cookbook - Second Edition", "1785886193", 44.99, R.drawable.libro2);
        listLibros.add(libro);
        libro = new Libro("Android Programming for Beginners", "9781785889035", 48.00, R.drawable.libro3);
        listLibros.add(libro);
        libro = new Libro("Learn Java for Android Development","1430264543", 56.00 ,R.drawable.libro4);
        listLibros.add(libro);
        libro = new Libro("Beginning Android Programming with Android Studio","9781118705599", 33.49 ,R.drawable.libro5);
        listLibros.add(libro);
        libro = new Libro("Programming Kotlin","9781787126367", 33.00 ,R.drawable.libro6);
        listLibros.add(libro);
        libro = new Libro("Java: A Beginner's Guide, Sixth Edition","9780071809252", 42.00 ,R.drawable.libro7);
        listLibros.add(libro);
        libro = new Libro("Learn Java the Easy Way","9781593278465", 51.00 ,R.drawable.libro8);
        listLibros.add(libro);
        libro = new Libro("Learning Python Powerful Object-Oriented Programming","9781306809481", 43.00 ,R.drawable.libro9);
        listLibros.add(libro);
        return listLibros;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_catalogo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Libro libro = (Libro) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, Detalle.class);
        intent.putExtra("isbn", libro.getIsbn());
        intent.putExtra("titulo", libro.getTitulo());
        intent.putExtra("precio", libro.getPrecio());
        intent.putExtra("imagen", libro.getIdImagen());
        startActivity(intent);
    }
}
