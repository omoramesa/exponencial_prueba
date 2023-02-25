package com.exponencial.prueba.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tiendas_productos")
public class TiendasProducto {
    @EmbeddedId
    private TiendasProductoPK id;

    private Integer cantidad;

    @ManyToOne
    @MapsId("idTienda")
    @JoinColumn(name = "id_tienda", insertable = false, updatable = false)
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public TiendasProductoPK getId() {
        return id;
    }

    public void setId(TiendasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
