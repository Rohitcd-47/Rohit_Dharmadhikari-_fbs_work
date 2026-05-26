package com.myntra.model;

public class OrderItem {
    private int orderItemId;
    private int orderId;
    private int productId;
    private int quantity;
    private double priceAtPurchase;
    private boolean isCancelled;  // ADD THIS FIELD
    private Product product;

    public OrderItem() {}

    public OrderItem(int orderItemId, int orderId, int productId, int quantity, double priceAtPurchase) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
        this.isCancelled = false;
    }

    // Getters and Setters
    public int getOrderItemId() { return orderItemId; }
    public void setOrderItemId(int orderItemId) { this.orderItemId = orderItemId; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPriceAtPurchase() { return priceAtPurchase; }
    public void setPriceAtPurchase(double priceAtPurchase) { this.priceAtPurchase = priceAtPurchase; }
    
    public boolean isCancelled() { return isCancelled; }  // ADD THIS
    public void setCancelled(boolean isCancelled) { this.isCancelled = isCancelled; }  // ADD THIS

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}