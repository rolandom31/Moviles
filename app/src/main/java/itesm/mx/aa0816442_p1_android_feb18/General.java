package itesm.mx.aa0816442_p1_android_feb18;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Rolando on 15/02/18.
 */

public class General extends Application {
    private ArrayList<Libro> arrayLibro;
    private double total;
    public General(){
        this.arrayLibro= new ArrayList<Libro>();
        this.total=0.00;
    }
    public ArrayList<Libro>getArrayLibro(){return arrayLibro;}

    public void setArrayLibro (ArrayList<Libro> arrayLibro){this.arrayLibro = arrayLibro;}

    public void addLibro(Libro lib){this.arrayLibro.add(lib);}
}
