package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cart;

    public Cart(){
        cart = new ArrayList<>();
    }

    public void addCartItem(CartItem cartItem){
        cart.add(cartItem);
    }

    public List<CartItem> getCartList(){
        return cart;
    }

    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public int getItemCount(){
        return cart.size();
    }

    public int getTotalAmount(){
        int totalAmount = 0;
        for (CartItem e : cart){
            totalAmount = totalAmount + e.getTotalPrice();
        }
        return totalAmount;
    }
    public void increaseQuantity(Product product){
        for(CartItem e : cart){
            if (e.getProduct().equals(product)){
                e.increase();
                break;
            }
        }
    }

    public void addProduct(Product product) {
        boolean findProduct = false;
        for (CartItem e : cart) {
            if (e.getProduct().equals(product)) {
                findProduct = true;
                e.increase();
                break;
            }
        }
        if (!findProduct) {
            cart.add(new CartItem(product, 1));
        }
    }

    public void emptyCart(){
        cart.clear();
    }
}
