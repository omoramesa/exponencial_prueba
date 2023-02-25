package com.exponencial.prueba.web.controller;

import com.exponencial.prueba.domain.Product;
import com.exponencial.prueba.domain.Store;
import com.exponencial.prueba.domain.service.StoreService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

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
   /** @PutMapping("/update/{id}")
    public ResponseEntity<Store> edit(@PathVariable("id") int storeId, @RequestBody Store store) {
        Optional<Store> storeEdit = storeService.getStore(storeId);
        if(storeEdit.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Store storeDB = storeEdit.get();
        storeDB.setName(store.getName());
        return new ResponseEntity<>(storeService.save(storeDB), HttpStatus.CREATED);
    }*/

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
