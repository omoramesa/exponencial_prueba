package com.exponencial.prueba.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tiendas")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Integer idTienda;

    private String nombre;

    @OneToMany(mappedBy =  "tienda", cascade = {CascadeType.ALL})
    private List<TiendasProducto> productos;

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TiendasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<TiendasProducto> productos) {
        this.productos = productos;
    }
}
