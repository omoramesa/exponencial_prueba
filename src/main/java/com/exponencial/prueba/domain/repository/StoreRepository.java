package com.exponencial.prueba.domain.repository;

import com.exponencial.prueba.domain.Product;
import com.exponencial.prueba.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {
    List<Store> getAll();
    Optional<Store> getStore(int storeId);
    Store save(Store store);
    void delete(int storeId);
}
