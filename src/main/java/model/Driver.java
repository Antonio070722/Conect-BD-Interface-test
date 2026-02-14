package model;

public class Driver {
    public String numeroConductor;
    public String nombre;
    public String apellido;

    public Driver(){}

    public Driver(String numeroConductor, String nombre, String apellido){
        this.numeroConductor=numeroConductor;
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public String getNumeroConductor() {
        return numeroConductor;
    }

    public void setNumeroConductor(String numeroConductor) {
        this.numeroConductor = numeroConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "numeroConductor=" + numeroConductor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
