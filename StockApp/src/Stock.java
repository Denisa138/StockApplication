import java.util.*;
import java.math.BigDecimal;
public class Stock {
 private ArrayList<StockItem> stockItems = new ArrayList<StockItem>();
   
public void add(Product product2, int quantity2)
   {  
	Iterator<StockItem> itr = stockItems.iterator();
    while (itr.hasNext()) {
        StockItem nextItem = itr.next();
        if (nextItem.getProductName() == product2.getName()) {
        	int finalQuantity = nextItem.getQuantity() + quantity2;
            nextItem.setQuantity(finalQuantity);
            return;
        }
    }	     
     stockItems.add(new StockItem(product2, quantity2));
   }
  
  public void remove(String product1)
   {  
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.getProductName()== product1) {
              itr.remove();
          }
      }
   }
  
  public void updateProductPrice(Product product1, BigDecimal price)
  {
	  StockItem found = null;
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.getProductName()== product1.getName()) {
        	  found = nextItem;
          }
      }
     found.setProductPrice(price);
  }
  
  public BigDecimal getProductPrice(String name)
  {
	  for(StockItem product : stockItems) {
	        if(product.getProductName().equals(name)) {
	            return product.getProductPrice();
	        }
	    }
	 return BigDecimal.ZERO;
  }
  
  public int getProductsStock(Product product1)
  {
	  StockItem found = null;
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.getProductName()== product1.getName()) {
              found = nextItem;
          }
      }
	return found.getQuantity();
  }
  
  public void setProductsStock(Product product1, int quantity)
  {
	  StockItem found = null;
	  Iterator<StockItem> itr = stockItems.iterator();
      while (itr.hasNext()) {
          StockItem nextItem = itr.next();
          if (nextItem.getProductName()== product1.getName()) {
              found = nextItem;
          }
      }
	 found.setQuantity(quantity);
  }
  
  public Product search(String name)
  {
	  StockItem found = null;
	  for(StockItem product : stockItems) {
	        if(product.getProductName().equals(name)) {
	            return product.productReturn();
	        }
	    }
	 return found.productReturn();
  }
  
  public ArrayList<StockItem> returnStockItems()
  {  
	   return stockItems;
  }
  
  

}
