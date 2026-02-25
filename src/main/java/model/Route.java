package model;

public class Route {

    public String Registro;
    public int numConductor;
    public int idLugar;
    public String dia_semana;

    public Route(){}

    public Route(String Registro, int numConductor, int idLugar, String dia_semana) {
        this.Registro = Registro;
        this.numConductor = numConductor;
        this.idLugar = idLugar;
        this.dia_semana = dia_semana;
    }

    public String getRegistro() {
        return Registro;
    }

    public void setRegistro(String registro) {
        Registro = registro;
    }

    public int getNumConductor() {
        return numConductor;
    }

    public void setNumConductor(int numConductor) {
        this.numConductor = numConductor;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    @Override
    public String toString() {
        return "Route{" +
                "Registro='" + Registro + '\'' +
                ", numConductor=" + numConductor +
                ", idLugar=" + idLugar +
                ", dia_semana='" + dia_semana + '\'' +
                '}';
    }
}
