package com.rest_api_crud.services;

import java.util.List;

import com.rest_api_crud.dao.ProductRepo;
import com.rest_api_crud.entites.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepo productRepo;

  public List<Product> listAll() {
    return productRepo.findAll();
  }

  public void save(Product product) {
    productRepo.save(product);
  }

  public Product getProductById(Integer id) {
    return productRepo.findById(id).get();
  }

  public void deleteProductById(Integer id) {
    productRepo.deleteById(id);
  }

}
