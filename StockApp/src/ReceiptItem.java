import java.util.Currency;
import java.math.BigDecimal;

public class ReceiptItem {
   String productName;
   Currency ppUnit;
   int quantity;
   BigDecimal totalPrice = BigDecimal.ZERO;
   
   ReceiptItem(String name,String option, int size)
   {
	   this.productName = name;
	   ppUnit = Currency.getInstance(option);
	   this.quantity = size;
   }
   
   String getProductName()
   {
	   return productName;
   }
   
   void setProductName(String name)
   {
	   productName = name;
   }
   
   int getProductQuantity()
   {
	   return quantity;
   }
   
   void setProductQuantity(int q)
   {
	   quantity = q;
   }
   
   void setTotalOfProduct(Stock stoc)
   { 
	  totalPrice = stoc.getProductPrice(productName).multiply(new BigDecimal(quantity));   
   }
   
   BigDecimal getTotalOfProduct()
   {
	   return totalPrice;
   }
    
   String getPPUnit()
   {
	   return ppUnit.getDisplayName();
   }
   
   @Override
   public String toString() {
        return ("\nProduct:'"+this.getProductName()+
                    "' Quantity: '"+ this.getProductQuantity() +
                    "' Price: '"+ this.getTotalOfProduct() +
                    "' Currency: '" + this.getPPUnit() + "' ");
   }
}
