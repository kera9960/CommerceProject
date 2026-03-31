package com.example.commerce;

import java.util.Scanner;
import java.util.List;

public class CommerceSystem {
    private List<Category> categories;
    private Scanner sc = new Scanner(System.in);
    private Cart cart = new Cart();

    public CommerceSystem(List<Category> categories){
        this.categories = categories;
    }

    public void start() {
        int categoryChoice;
        int productChoice;
        do {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categories.size(); i++) {
                Category category = categories.get(i);
                System.out.println(i + 1 + ". " + category.getCategoryName());
            }
            System.out.println("0. 종료");
            if (!cart.isEmpty()) {
                System.out.println();
                System.out.println("[ 주문 관리 ]");
                System.out.println("4. 장바구니 확인     | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. 주문 취소        | 진행중인 주문을 취소합니다.");
            }
            categoryChoice = sc.nextInt();
            System.out.println();
            if (categoryChoice == 0) {
                break;
            } else if (categoryChoice == 4) {
                for (CartItem  e : cart.getCartList()){
                    System.out.printf("%-15s | %,d원 | %d개%n",e.getProductName(), e.getProductPrice(), e.getQuantity());
                }
                System.out.printf("총 금액: %,d원%n", cart.getTotalAmount());
                System.out.println("위와 같이 주문하겠습니까?");
                System.out.println("1. 주문 확정     2. 메인으로 돌아가기");

                int orderConfirmed = sc.nextInt();
                if (orderConfirmed == 1){
                    System.out.println("주문이 완료되었습니다. 총 금액: " + cart.getTotalAmount());

                    for (CartItem e : cart.getCartList()){
                        Product product = e.getProduct();
                        int beforeReductionStock = product.getStock();

                        for (int i = 0; i < e.getQuantity(); i++){
                            product.decreaseStock();
                        }
                        int afterReductionStock = product.getStock();
                        System.out.println(product.getName()
                                + " 재고가" + beforeReductionStock + "개 ->" + afterReductionStock + "개로 업데이트되었습니다.");
                    }
                    cart.emptyCart();

                } else if (orderConfirmed == 2) {
                    System.out.println("메인으로 돌아갑니다.");

                }
                continue;
            }


            int listIndex = categoryChoice - 1;
            Category selectCategory = categories.get(listIndex);
            System.out.println("[ " + selectCategory.getCategoryName() + " 카테고리 ]");
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

                System.out.println("상품을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인      2. 취소");
                int inCart = sc.nextInt();
                if (inCart == 1){
                    cart.addProduct(selectProduct);
                    System.out.println(selectProduct.getName() + "(이)가 장바구니에 추가되었습니다.");
                } else if (inCart ==2){
                    System.out.println("장바구니 담기를 취소하셨습니다.");
                }

            }

        } while (categoryChoice != 0);
        System.out.println("커머스 플랫폼을 종료합니다.");
        sc.close();
    }
}
