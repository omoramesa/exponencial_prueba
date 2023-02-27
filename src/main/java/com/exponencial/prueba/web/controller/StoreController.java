package com.exponencial.prueba.web.controller;


import com.exponencial.prueba.domain.Store;
import com.exponencial.prueba.domain.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stores")
@CrossOrigin(origins = "http://localhost:3000")
public class StoreController {
    @Autowired
    private StoreService storeService;

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<Store>> getAll() {
        return new ResponseEntity<>(storeService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Store> getStore(@PathVariable("id") int storeId){
        return storeService.getStore(storeId)
                .map(store -> new ResponseEntity<>(store, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Store> save(@RequestBody Store store) {
        return new ResponseEntity<>(storeService.save(store), HttpStatus.CREATED);
    }

       @PutMapping("/update/{id}")
    public ResponseEntity<Store> edit(@PathVariable("id") Integer storeId, @RequestBody Store store) {

        Optional<Store> storeEdit = storeService.edit(storeId, store);
        if(storeEdit.isPresent()){
            return new ResponseEntity(storeEdit, HttpStatus.CREATED);
        }else{
            return new ResponseEntity(storeEdit, HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int storeId){
        try {
            if (storeService.delete(storeId)){
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
