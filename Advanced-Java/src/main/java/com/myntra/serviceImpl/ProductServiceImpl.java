package com.myntra.serviceImpl;

import com.myntra.dao.ProductDAO;
import com.myntra.daoImpl.ProductDAOImpl;
import com.myntra.model.Product;
import com.myntra.service.ProductService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myntra.util.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public boolean addProduct(Product product) {
        try {
            return productDAO.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productDAO.getAllProducts();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean updateProduct(Product product) {

        try {

            Connection con =
            DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(

            "UPDATE products SET name=?, description=?, price=?, category=?, stock_quantity=?, image_path=? WHERE product_id=?"

            );

            ps.setString(1, product.getName());

            ps.setString(2,
            product.getDescription());

            ps.setDouble(3,
            product.getPrice());

            ps.setString(4,
            product.getCategory());

            ps.setInt(5,
            product.getStockQuantity());

            ps.setString(6,
            product.getImagePath());

            ps.setInt(7,
            product.getProductId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {

        try {

            Connection con =
            DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(

            "DELETE FROM products WHERE product_id=?"

            );

            ps.setInt(1, productId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    
    
    @Override
    public Product getProductById(int productId) {

        Product product = null;

        try {

            Connection con =
            DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(

            "SELECT * FROM products WHERE product_id=?"

            );

            ps.setInt(1, productId);

            ResultSet rs =
            ps.executeQuery();

            if(rs.next()) {

                product = new Product();

                product.setProductId(
                rs.getInt("product_id"));

                product.setName(
                rs.getString("name"));

                product.setDescription(
                rs.getString("description"));

                product.setPrice(
                rs.getDouble("price"));

                product.setCategory(
                rs.getString("category"));

                product.setStockQuantity(
                rs.getInt("stock_quantity"));

                product.setImagePath(
                rs.getString("image_path"));
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return product;
    }
}