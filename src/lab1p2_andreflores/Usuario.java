package lab1p2_andreflores;

import java.util.Date;

public class Usuario {

    String nombre;
    String apellido;
    Date fechaNacimiento;
    String correoElec;
    String contra;

    public Usuario(String nombre, String apellido, Date fechaNacimiento, String correoElec, String contra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElec = correoElec;
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreoElec() {
        return correoElec;
    }

    public String getContra() {
        return contra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCorreoElec(String correoElec) {
        this.correoElec = correoElec;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", correoElec=" + correoElec + ", contra=" + contra + '}';
    }

}
