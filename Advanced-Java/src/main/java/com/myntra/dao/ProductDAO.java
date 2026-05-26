package com.myntra.dao;

import com.myntra.model.Product;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO 
{
    boolean addProduct(Product product) throws SQLException;
    List<Product> getAllProducts() throws SQLException;
}