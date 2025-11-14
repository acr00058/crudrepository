package com.arturokio.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.arturokio.springboot_crud.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{

}
