package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private List<Product> products = new ArrayList<Product>();
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void addProduct(Product item){
        products.add(item);
    }
    public List<Product> getProducts(){
        return products;
    }

}
