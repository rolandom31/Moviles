package itesm.mx.aa0816442_p1_android_feb18;

/**
 * Created by Rolando on 15/02/18.
 */

public class Libro {
    private String titulo;
    private String isbn;
    private double precio;
    private int idImagen;

    //constructor
    public Libro (String titulo, String isbn, Double precio, int idImagen){
        this.titulo=titulo;
        this.isbn=isbn;
        this.precio=precio;
        this.idImagen=idImagen;
    }

    public void setTitulo (String titulo) {this.titulo=titulo;}
    public String getTitulo(){return titulo;}

    public void setPrecio (double precio) {this.precio=precio;}
    public double getPrecio(){return precio;}

    public void setIsbn (String isbn) {this.isbn=isbn;}
    public String getIsbn(){return isbn;}

    public void setIdImagen (int idImagen) {this.idImagen=idImagen;}
    public int getIdImagen(){return idImagen;}
}
