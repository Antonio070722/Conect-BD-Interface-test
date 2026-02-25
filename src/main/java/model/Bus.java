package model;

public class Bus {
    public String Registro;
    public String Tipo;
    public String Licencia;

    public Bus(){}

    public Bus(String Registro, String Tipo, String Licencia){
        this.Registro = Registro;
        this.Tipo=Tipo;
        this.Licencia=Licencia;
    }

    public String getRegistro() {
        return Registro;
    }

    public void setRegistro(String registro) {
        Registro = registro;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String licencia) {
        Licencia = licencia;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "Registro='" + Registro + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Licencia='" + Licencia + '\'' +
                '}';
    }
}
