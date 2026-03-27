package com.example.commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Product> products;
    private Scanner sc = new Scanner(System.in);

    public CommerceSystem(List<Product> products){
        this.products = products;
    }
    public void start(){
        int choice;
        do {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (int i = 0; i < products.size(); i++) {

                Product item = products.get(i);
                System.out.printf("%d. %-15s | %10s | %s%n"
                        , i + 1
                        , item.getName()
                        , String.format("%,d", item.getPrice()) + "원"
                        , item.getExplanation());
            }
            System.out.println("0. 종료");
            choice = sc.nextInt();

        } while (choice != 0);
        System.out.println("커머스 플랫폼을 종료합니다.");
    }

}
