package com.myntra.service;

import com.myntra.model.Product;
import java.util.List;

public interface ProductService 
{
    boolean addProduct(Product product);
    List<Product> getAllProducts();
    boolean updateProduct(Product product);
    Product getProductById(int productId);
    boolean deleteProduct(int productId);
}