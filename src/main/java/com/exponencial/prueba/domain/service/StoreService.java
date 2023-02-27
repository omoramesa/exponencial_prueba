package com.exponencial.prueba.domain.service;


import com.exponencial.prueba.domain.Store;
import com.exponencial.prueba.domain.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAll(){
        return storeRepository.getAll();
    }
    public Optional<Store> getStore(int storeId){
        return storeRepository.getStore(storeId);
    }

    public Store save(Store store){
        return storeRepository.save(store);
    }

    public Optional<Store> edit(Integer storeId, Store store) {
        Optional<Store> storeEdit = getStore(storeId);
        if(!storeEdit.isPresent()){
            return Optional.empty();
        }
        Store storeDB = storeEdit.get();
        storeDB.setName(store.getName());
        return Optional.of(storeRepository.save(storeDB));
    }
    public boolean delete(int storeId){
        return getStore(storeId).map(store -> {
            storeRepository.delete(storeId);
            return true;
        }).orElse(false);
    }

}
