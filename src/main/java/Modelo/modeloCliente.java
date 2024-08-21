
package Modelo;


public class modeloCliente {

    int IdCliente;
    String Nombre;
    String dni;
    String telefono;
    String email;
    String direccion;
    String localidad;
    String UfechaModificacion;
    String Observaciones;
    String PersAutorizadas;
    int LimiteCompra;

    public String getPersAutorizadas() {
        return PersAutorizadas;
    }

    public void setPersAutorizadas(String PersAutorizadas) {
        this.PersAutorizadas = PersAutorizadas;
    }

    public int getLimiteCompra() {
        return LimiteCompra;
    }

    public void setLimiteCompra(int LimiteCompra) {
        this.LimiteCompra = LimiteCompra;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getUfechaModificacion() {
        return UfechaModificacion;
    }

    public void setUfechaModificacion(String UfechaModificacion) {
        this.UfechaModificacion = UfechaModificacion;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}
