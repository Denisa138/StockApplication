import java.util.ArrayList;
import java.util.Iterator;
import java.math.BigDecimal;

public class Receipt {
   private ArrayList<ReceiptItem> receiptItems = new ArrayList<ReceiptItem>();
  
   public BigDecimal getTotalForProduct(String nameOfProduct, Stock stoc)
   {     
	      ReceiptItem found = null;
		  Iterator<ReceiptItem> itr = receiptItems.iterator();
	      while (itr.hasNext()) {
	          ReceiptItem nextItem = itr.next();
	          if (nextItem.getProductName() == nameOfProduct) {
	        	  found = nextItem;
	          }
	      }
	      
	     found.setTotalOfProduct(stoc);
	     return found.getTotalOfProduct();
   }
   
   public BigDecimal getTotal(Stock stoc)
   {   
	   BigDecimal totalSum = BigDecimal.ZERO;
	   Iterator<ReceiptItem> itr = receiptItems.iterator();
	      while (itr.hasNext()) {
	          ReceiptItem nextItem = itr.next();
	          nextItem.setTotalOfProduct(stoc);
	          totalSum = totalSum.add(nextItem.getTotalOfProduct());
	      }
	      return totalSum;
   }
   
   public void add(String nameOfProduct, String currency, int quantityDemanded)
   {  
	Iterator<ReceiptItem> itr = receiptItems.iterator();
    while (itr.hasNext()) {
    	ReceiptItem nextItem = itr.next();
        if (nextItem.getProductName() == nameOfProduct) {
        	int finalQuantity = nextItem.getProductQuantity() + quantityDemanded;
            nextItem.setProductQuantity(finalQuantity);
            return;
        }
    }	     
     receiptItems.add(new ReceiptItem(nameOfProduct, currency,quantityDemanded));
   }
   
   public void remove(String nameOfProduct)
   {  
	  Iterator<ReceiptItem> itr = receiptItems.iterator();
      while (itr.hasNext()) {
    	  ReceiptItem nextItem = itr.next();
          if (nextItem.getProductName() == nameOfProduct) {
              itr.remove();
          }
      }
   }
   
   public int getQuantity(String nameOfProduct)
   {
	   int quantity = 0;
	   Iterator<ReceiptItem> itr = receiptItems.iterator();
	      while (itr.hasNext()) {
	    	  ReceiptItem nextItem = itr.next();
	          if (nextItem.getProductName() == nameOfProduct) {
	             quantity = nextItem.getProductQuantity();
	          }
	      }
	      return quantity;
   }
   
   public String getCurrency(int index)
   {
	   return receiptItems.get(index).getPPUnit();
   }
   
   public ArrayList<ReceiptItem> returnReceiptItems()
   {  
	   return receiptItems;
   }
}
