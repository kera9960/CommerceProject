package com.example.commerce;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getTotalPrice(){
        return product.getPrice() * quantity;
    }

    public String getProductName(){
        return product.getName();
    }

    public int getProductPrice(){
        return product.getPrice();
    }

    public void increase(){
        quantity = quantity + 1;
    }
}
