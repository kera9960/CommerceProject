package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product product1 = new Product("Galaxy S25",1200000,"최신 안드로이드 스마트폰",30);
        Product product2 = new Product("iPhone 16",1350000,"Apple의 최신 스마트폰",30);
        Product product3 = new Product("MacBook Pro",2400000,"M3 칩셋이 탑재된 노트북",30);
        Product product4 = new Product("AirPods Pro",350000,"노이즈 캔슬링 무선 이어폰",30);

        List<Product> products = new ArrayList<Product>();

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
        int i;
        for (i = 0; i < products.size(); i++){
            Product item = products.get(i);
            System.out.printf("%d. %-15s | %10s | %s%n"
                    ,i+1
                    ,item.getName()
                    ,String.format("%,d", item.getPrice()) + "원"
                    ,item.getExplanation());
        }
        System.out.println("0. 종료");
        int end = sc.nextInt();
        if (end == 0){
            System.out.println("커머스 플랫폼을 종료합니다.");
        }
    }
}
