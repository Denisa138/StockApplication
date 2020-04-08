import java.util.ArrayList;
import java.util.Iterator;

public class Store {
   private String name;
   private String category;
   private Stock stoc;
   private ArrayList<CashRegister> cashRegisters = new ArrayList<CashRegister>();
   private ArrayList<Seller> sellers = new ArrayList<Seller>();
   private ArrayList<Administrator> administrators = new ArrayList<Administrator>();
   
   Store(String store, String c,Stock stock)
   {
	   this.name = store;
	   this.category = c;
	   this.stoc = stock;
   }
   
   String getName()
   {
	   return name;
   }
   
   void setName(String nameOfStore)
   {
	   name = nameOfStore;
   }
   
   String getCategory()
   {
	   return category;
   }
   
   void setStock(Stock stock)
   {
	   stoc = stock;
   }
    
   public void addNewCashRegister(String storeName, String seller)
   {	     
	   cashRegisters.add(new CashRegister(storeName, seller));
   }
   
   public void removeCashRegister(String storeName, String seller)
   {	    
	   Iterator<CashRegister> itr = cashRegisters.iterator();
	      while (itr.hasNext()) {
	    	  CashRegister nextItem = itr.next();
	          if (nextItem.getStoreName().equalsIgnoreCase(storeName) && nextItem.getFiscalIdentifier().equalsIgnoreCase(seller)) {
	              itr.remove();
	          }
	      }
   }
   
   public CashRegister getCashRegister(int index)
   {
	   return cashRegisters.get(index);
   }
   
   public void addNewSeller(String name, String phoneNumber, String adress)
   {	     
	  sellers.add(new Seller(new EmployeeInfo(name,phoneNumber, adress)));
   }
   
   public Seller getSeller(int index)
   {
	   return sellers.get(index);
   }
   
   public void addNewAdministrator(String name, String phoneNumber, String adress)
   {	     
	  administrators.add(new Administrator(new EmployeeInfo(name,phoneNumber, adress)));
   }
   
   public Administrator getAdministrator(int index)
   {
	   return administrators.get(index);
   }
   
   public ArrayList<CashRegister> returnCashRegisters()
   {  
	   return cashRegisters;
   }
   
   public Stock getStock()
   {
	   return stoc;
   }
}
