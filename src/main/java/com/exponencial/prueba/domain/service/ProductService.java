package com.exponencial.prueba.domain.service;

import com.exponencial.prueba.domain.Product;
import com.exponencial.prueba.domain.Store;
import com.exponencial.prueba.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> edit(Integer productId, Product product) {
        Optional<Product> productEdit = getProduct(productId);
        if(!productEdit.isPresent()){
            return Optional.empty();
        }
        Product productDB = productEdit.get();
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setPrice(product.getPrice());
        return Optional.of(productRepository.save(productDB));
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
