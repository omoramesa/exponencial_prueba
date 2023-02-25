package com.exponencial.prueba.persistence.crud;

import com.exponencial.prueba.persistence.entity.Tienda;
import org.springframework.data.repository.CrudRepository;

public interface TiendaCrudRepository extends CrudRepository<Tienda, Integer> {

}
