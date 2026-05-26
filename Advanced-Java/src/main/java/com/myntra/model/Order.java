package com.myntra.model;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int userId;
    private double totalAmount;
    private Timestamp orderDate;
    private String cardHolderName;
    private String shippingAddress;
    private String phoneNumber;
    private String status;  // NEW FIELD

    public Order() {}

    public Order(int orderId, int userId, double totalAmount, Timestamp orderDate, 
                 String cardHolderName, String shippingAddress, String phoneNumber, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.cardHolderName = cardHolderName;
        this.shippingAddress = shippingAddress;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public Timestamp getOrderDate() { return orderDate; }
    public void setOrderDate(Timestamp orderDate) { this.orderDate = orderDate; }

    public String getCardHolderName() { return cardHolderName; }
    public void setCardHolderName(String cardHolderName) { this.cardHolderName = cardHolderName; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}