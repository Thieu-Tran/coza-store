package com.cyber.cozastore.payload.request;

import com.cyber.cozastore.entity.OrderEntity;
import com.cyber.cozastore.entity.ProductEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderDetailRequest {
    private ProductEntity product;
    private OrderEntity order;
    private int quantity;
    private double price;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
