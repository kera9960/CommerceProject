package com.example.commerce;

public class Product {
       private String name;
       private int price;
       private String explanation;
       private int stock;

       public Product(String name,int price,String explanation,int stock){
              this.name = name;
              this.price = price;
              this.explanation = explanation;
              this.stock = stock;
       }

       public String getName(){
              return name;
       }
       public int getPrice(){
              return price;
       }
       public String getExplanation(){
              return explanation;
       }
       public int getStock(){
              return stock;
       }

       public void decreaseStock(){
              if (stock >= 1){
              this.stock = this.stock - 1;
              } else {
                     throw new IllegalStateException("재고 부족");
              }
       }
}
