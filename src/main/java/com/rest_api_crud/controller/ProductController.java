package com.rest_api_crud.controller;

import java.util.List;

import com.rest_api_crud.entites.Product;
import com.rest_api_crud.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public List<Product> list() {
    return productService.listAll();
  }

  // @GetMapping("/product/{id}")
  // public Product getProduct(@PathVariable("id") int id) {
  // return productService.getProductById(id);
  // }

  @GetMapping("/product/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
    try {
      Product product = productService.getProductById(id);
      return new ResponseEntity<Product>(product, HttpStatus.OK);
    } catch (Exception e) {
      // TODO: handle exception
      return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addProduct(@RequestBody Product product) {
    productService.save(product);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteProduct(@PathVariable("id") int id) {
    productService.deleteProductById(id);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
    try {
      Product existingProduct = productService.getProductById(id);
      productService.save(product);
      return new ResponseEntity<>(HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }
}
