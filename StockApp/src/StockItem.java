import java.math.BigDecimal;

public class StockItem {
   private Product product;
   private int quantity;
  
   StockItem(Product product, int q)
   {
	   this.product = product;
	   this.quantity = q;
   }
   
   int getQuantity()
   {
	   return quantity;
   }
   
   void setQuantity(int q)
   {
	   quantity = q;
   }
   
   public String getProductName() {
       return  product.getName();
   }
   
   @Override
   public String toString()
   {
	   return ("\nProduct:'"+this.getProductName()+
               "' Quantity: '"+ this.getQuantity()+ "'");
   }
   
   public void setProductPrice(BigDecimal newPrice)
   {
	   product.setPrice(newPrice);
   }
   
   public BigDecimal getProductPrice()
   {
	   return product.getPrice();
   }
   
   public Stock getStock()
   {
	   return product.getStock();
   }
   
   public Product productReturn()
   {
	   return product;
   }
   
}
