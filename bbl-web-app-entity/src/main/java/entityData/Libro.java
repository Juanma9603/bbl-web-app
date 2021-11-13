package entityData;

import java.util.Date;

public class Libro {
    private int ID;
    private String Nombre;
    private String Categoria;
    private int Tomo;
    private Date Registro;

    public Libro() {
        this.ID=0;
        this.Nombre="";
        this.Categoria="";
        this.Tomo=0;
        this.Registro=new Date();
    }

    public Libro(int ID, String nombre, String categoria, int tomo, Date registro) {
        this.ID = ID;
        this.Nombre = nombre;
        this.Categoria = categoria;
        this.Tomo = tomo;
        this.Registro= registro;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {

        return Nombre;
    }

    public void setNombre(String nombre) {

        this.Nombre = nombre;
    }

    public String getCategoria() {

        return Categoria;
    }

    public void setCategoria(String categoria) {

        this.Categoria = categoria;
    }

    public int getTomo() {
        return Tomo;
    }

    public void setTomo(int tomo) {

        this.Tomo = tomo;
    }

    public Date getRegistro(){
        return Registro;
    }

    public void setRegistro(Date registro){
        this.Registro= registro;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Tomo=" + Tomo +
                ", Registro=" + Registro +
                '}';
    }
}
