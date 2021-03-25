package com.rest_api_crud.dao;

import com.rest_api_crud.entites.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
