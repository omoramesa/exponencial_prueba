package com.exponencial.prueba.persistence.crud;

import com.exponencial.prueba.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}
