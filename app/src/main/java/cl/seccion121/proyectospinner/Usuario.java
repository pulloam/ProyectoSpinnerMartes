package cl.seccion121.proyectospinner;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String correo;
    private String clave;
    private int edad;

    //region constructores
    public Usuario(){}

    public Usuario(String nombre, String correo, String clave){
        setNombre(nombre);
        setCorreo(correo);
        setClave(clave);
    }
    //endregion

    //region get y set

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre.toUpperCase();
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo.toUpperCase();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    //endregion
}
