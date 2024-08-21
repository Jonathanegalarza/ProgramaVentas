/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ruben
 */
public class modeloProducto {

    int idProducto;
    String Producto;
    Double PrecioProducto;
    Double Neto;
    Double Iva;
    int Stock;
    String UltimaModificacion;

    public String getUltimaModificacion() {
        return UltimaModificacion;
    }

    public void setUltimaModificacion(String UltimaModificacion) {
        this.UltimaModificacion = UltimaModificacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public Double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(Double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    public Double getNeto() {
        return Neto;
    }

    public void setNeto(Double Neto) {
        this.Neto = Neto;
    }

    public Double getIva() {
        return Iva;
    }

    public void setIva(Double Iva) {
        this.Iva = Iva;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

}
