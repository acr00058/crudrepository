package com.arturokio.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arturokio.springboot_crud.entities.Product;
import com.arturokio.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> delete(Product product) {
        Optional<Product> optionalProduct = repository.findById(product.getId());
        optionalProduct.ifPresent((prod) ->{
            repository.delete(prod);
        });
        return optionalProduct;
    }

}
