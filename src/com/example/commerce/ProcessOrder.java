package com.example.commerce;

public class ProcessOrder {
    private Cart cart;

    public ProcessOrder(Cart cart){
        this.cart = cart;
    }

    public void viewInCart(){
        for (CartItem  e : cart.getCartList()){
            System.out.printf("%-15s | %,d원 | %d개%n",e.getProductName(), e.getProductPrice(), e.getQuantity());
        }
        System.out.printf("총 금액: %,d원%n", cart.getTotalAmount());
    }

    public void confirmPurchase(){
        boolean isEnoughStock = true;
        for (CartItem e : cart.getCartList()) {
            if (e.getQuantity() > e.getProduct().getStock()) {
                isEnoughStock = false;
                break;
            }
        }
        if (!isEnoughStock) {
            System.out.println("재고 부족으로 주문이 취소되었습니다.");
            return;
        }
        for (CartItem e : cart.getCartList()) {
            Product product = e.getProduct();
            int beforeReductionStock = product.getStock();

            for (int i = 0; i < e.getQuantity(); i++) {
                product.decreaseStock();
            }
            int afterReductionStock = product.getStock();
            System.out.println(product.getName()
                    + " 재고가 " + beforeReductionStock + "개 -> " + afterReductionStock + "개로 업데이트되었습니다.");
        }
        System.out.printf("주문이 완료되었습니다. 총 금액: %,d원%n", cart.getTotalAmount());
        cart.emptyCart();
    }

    public void cancelOrder(){
        cart.emptyCart();
        System.out.println("주문을 취소하셨습니다.");
    }
}
