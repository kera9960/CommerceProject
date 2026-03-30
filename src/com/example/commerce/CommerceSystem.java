package com.example.commerce;

import java.util.Scanner;
import java.util.List;

public class CommerceSystem {
    private List<Category> categories;
    private Scanner sc = new Scanner(System.in);

    public CommerceSystem(List<Category> categories){
        this.categories = categories;
    }

    public void start(){
        int categoryChoice;
        int productChoice;
        do {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categories.size(); i++ ){
                Category category = categories.get(i);
                System.out.println(i + 1 + ". " + category.getCategoryName());
            }
                System.out.println("0. 종료");
                categoryChoice = sc.nextInt();
                System.out.println();
                if (categoryChoice == 0){
                    break;
                }

                int listIndex = categoryChoice - 1;
                Category selectCategory = categories.get(listIndex);
                System.out.println("[ "+ selectCategory.getCategoryName() +" 카테고리 ]");
                List<Product> selectProducts = selectCategory.getProducts();

                while (true) {
                    for (int i = 0; i < selectProducts.size(); i++) {
                        Product product = selectProducts.get(i);
                        System.out.printf("%d. %-15s | %,d원 | %s%n", i + 1, product.getName(), product.getPrice(), product.getExplanation());
                    }
                    System.out.println("0. 뒤로가기");
                    productChoice = sc.nextInt();
                    if (productChoice == 0) {
                        break;
                    }
                    int selectIndex = productChoice - 1;
                    Product selectProduct = selectProducts.get(selectIndex);
                    System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개%n",
                            selectProduct.getName(),
                            selectProduct.getPrice(),
                            selectProduct.getExplanation(),
                            selectProduct.getStock());
                    System.out.println();
                }

        } while (categoryChoice != 0);
        System.out.println("커머스 플랫폼을 종료합니다.");
    }

}
