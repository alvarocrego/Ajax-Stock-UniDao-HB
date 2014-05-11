package net.rafaelaznar.bean;
// Generated Jan 21, 2014 12:40:47 PM by Hibernate Tools 3.6.0

import java.util.Date;

/**
 * Compra generated by hbm2java
 */
public class Compra implements java.io.Serializable {

    private Integer id = 0; //ojo, poner valores por defecto
    private Integer id_cliente; //modificado por rafa antes: idCliente
    private Integer id_producto; //modificado por rafa antes: idProducto
    private Integer cantidad;
    private Date fecha;
    private Integer idFactura;

    public Compra() {
    }

    public Compra(Integer idCliente, Integer idProducto, Integer cantidad, Date fecha, Integer idFactura) {
        this.id_cliente = idCliente;
        this.id_producto = idProducto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.idFactura = idFactura;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return this.id_cliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.id_cliente = idCliente;
    }

    public Integer getIdProducto() {
        return this.id_producto;
    }

    public void setIdProducto(Integer idProducto) {
        this.id_producto = idProducto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdFactura() {
        return this.idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

}