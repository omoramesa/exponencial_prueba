package com.exponencial.prueba.persistence;

import com.exponencial.prueba.domain.Product;
import com.exponencial.prueba.domain.Store;
import com.exponencial.prueba.domain.repository.StoreRepository;
import com.exponencial.prueba.persistence.crud.TiendaCrudRepository;
import com.exponencial.prueba.persistence.entity.Tienda;
import com.exponencial.prueba.persistence.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class TiendaRepository implements StoreRepository {
    @Autowired
    private TiendaCrudRepository tiendaCrudRepository;
    @Autowired
    private StoreMapper mapper;

    @Override
    public List<Store> getAll() {
        return mapper.toStores((List<Tienda>) tiendaCrudRepository.findAll());
    }
    @Override
    public Optional<Store> getStore(int storeId) {
        return tiendaCrudRepository.findById(storeId).map(tienda -> mapper.toStore(tienda));
    }
    @Override
    public Store save(Store store) {
        Tienda tienda = mapper.toTienda(store);
        tienda.getProductos().forEach(producto -> producto.setTienda(tienda));
        return mapper.toStore(tiendaCrudRepository.save(tienda));
    }

    @Override
    public void delete(int storeId) {
        tiendaCrudRepository.deleteById(storeId);
    }


}
