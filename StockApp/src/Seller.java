import java.math.BigDecimal;
public class Seller {
	private EmployeeInfo employeeInfo = null;
	
	   Seller(EmployeeInfo employeeInfo)
	   {
		   this.employeeInfo = employeeInfo;
	   }
	   
	   public int checkProductsStock(Product product2)
	   {
		   return product2.getStock().getProductsStock(product2);
	   }
	   
	   public BigDecimal sell(Product product2, int quantity, String currency, CashRegister a)
	   {
		   BigDecimal price = BigDecimal.ZERO;
		   if(checkProductsStock(product2) != 0)
		   {
			   int finalQuantity = checkProductsStock(product2) - quantity;
			   product2.getStock().setProductsStock(product2, finalQuantity);
			   price = a.registerNewProduct(product2.getName(),currency,quantity,product2.getStock());
		   }
		   return price;
	   }
	   	
		public void returnProducts(Product product,CashRegister a)
		{
			int quantityReturned = a.removeProductFromSell(product.getName());
			product.getStock().add(product, quantityReturned);
		}
		
		public String viewStock(Stock stock)
		{
			return stock.returnStockItems().toString();
		}
		
		String getName()
		{
			return employeeInfo.getName();
		}
}
