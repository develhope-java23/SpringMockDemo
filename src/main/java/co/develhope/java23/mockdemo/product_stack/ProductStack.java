package co.develhope.java23.mockdemo.product_stack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProductStack {
   @Id
   @GeneratedValue
   private long id;
   private String name;
   private int quantity;

   public ProductStack() {
   }

   public ProductStack(long id, String name, int quantity) {
      this.id = id;
      this.name = name;
      this.quantity = quantity;
   }

   public long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public int getQuantity() {
      return quantity;
   }
}
