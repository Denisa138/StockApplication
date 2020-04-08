
public class Administrator{
    private EmployeeInfo employeeInfo = null;
	
   Administrator(EmployeeInfo employeeInfo)
   {
	   this.employeeInfo = employeeInfo;
   }
   
   public void addProductsToStock(Product product2, int quantity2)
    {
      product2.getStock().add(product2, quantity2);
    }
   
   public void removeProductsFromStock(Product product2)
   {   
	   product2.getStock().remove(product2.getName());
   }
   
   public int checkProductsStock(Product product2)
   {
	   return product2.getStock().getProductsStock(product2);
   }
   
   String getEmployeeName()
   {
	   return employeeInfo.getName();
   }
  
}
