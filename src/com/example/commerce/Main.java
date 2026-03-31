package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Category> categories = new ArrayList<Category>();
        Category electronics = new Category("전자제품");
        Category clothes = new Category("의류");
        Category foods = new Category("식품");

        categories.add(electronics);
        categories.add(clothes);
        categories.add(foods);

        Product product1 = new Product("Galaxy S25",1200000,"최신 안드로이드 스마트폰",30);
        Product product2 = new Product("iPhone 16",1350000,"Apple의 최신 스마트폰",30);
        Product product3 = new Product("MacBook Pro",2400000,"M3 칩셋이 탑재된 노트북",30);
        Product product4 = new Product("AirPods Pro",350000,"노이즈 캔슬링 무선 이어폰",30);
        electronics.addProduct(product1);
        electronics.addProduct(product2);
        electronics.addProduct(product3);
        electronics.addProduct(product4);


        CommerceSystem system = new CommerceSystem(categories);
        system.start();
    }
}
