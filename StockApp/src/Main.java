import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Scanner; 
public class Main {
	@SuppressWarnings("null")
	private static Scanner input;

    public static void mainMenu(Store store1,Stock stoc1)
	{
		boolean exit;
		do {
			System.out.println("Choose an option:");
		    System.out.println("0 - Exit");
		    System.out.println("1 - Use as Administrator.");
		    System.out.println("2 - Use as Seller.");    
		try {
			input = new Scanner(System.in);
			int option = input.nextInt();
            
			switch(option)
			{
			case 0:
				exit = true;
				 System.out.println("You left the menu.");
			      System.exit(0);
				break;
			case 1:
				administrator(store1,stoc1);
				break;
			case 2:
				 seller(store1,stoc1);
				break;
			}
		}catch (NumberFormatException f) {}
		}while(!true);
	}
	
	public static void administrator(Store store1,Stock stoc1)
	{
		 do {
			System.out.println("Choose an option:");
		    System.out.println("0 - Back");
		    System.out.println("1 - Stock.");
		    System.out.println("2 - Cash registers.");    
		   
		try {
			input = new Scanner(System.in);
			int optiune = input.nextInt();
            
			switch(optiune)
			{
			case 0:
				mainMenu(store1, stoc1);
				break;
			case 1:
				administratorStock(store1,stoc1);
				break;
			case 2:
				administratorCashRegisters(store1,stoc1);
				break;
			}
		}catch (NumberFormatException f) {}
		    }while(true);
	}
    
	public static void administratorStock(Store store1,Stock stoc1)
	{
	 do {
		System.out.println("Choose an option:");
	    System.out.println("0 - Back");
	    System.out.println("1 - Add product.");
	    System.out.println("2 - Remove product."); 
	    System.out.println("3 - View stock.");
	   
	try {
		input = new Scanner(System.in);
		int optiune = input.nextInt();
        
		switch(optiune)
		{
		case 0:
			administrator(store1, stoc1);
			break;
		case 1:
			input = new Scanner(System.in);
			System.out.println("Enter product's name:");
			String name = input.next();
			System.out.println("Enter product's colour:");
			String  colour= input.next();
			System.out.println("Enter product's size:");
			String size= input.next();
			System.out.println("Enter product's category:");
			String category = input.next();
			System.out.println("Enter product's price:");
			BigDecimal price = input.nextBigDecimal();
			System.out.println("Enter product's quantity:");
			int quantity = input.nextInt();
			
			Product product1 = new Product(name,colour, size, category, price,stoc1);
			store1.getAdministrator(0).addProductsToStock(product1, quantity);
			break;
		case 2:
			input = new Scanner(System.in);
			System.out.println("Enter product's name:");
			String removedProduct = input.next();
			store1.getAdministrator(0).removeProductsFromStock(store1.getStock().search( removedProduct));
			break;
		case 3:
			System.out.println("The stock is:\n" + store1.getStock().returnStockItems().toString());
		}
	}catch (NumberFormatException f) {}
	    }while(true);	
	}
	
	public static void administratorCashRegisters(Store store1,Stock stoc1)
	{
		do {
			System.out.println("Choose an option:");
		    System.out.println("0 - Back");
		    System.out.println("1 - Add cashRegister.");
		    System.out.println("2 - Remove cashRegister.");   
		    System.out.println("3 - View cashRegisters.");
		   
		try {
			input = new Scanner(System.in);
			int optiune = input.nextInt();
            
			switch(optiune)
			{
			case 0:
				administratorStock(store1,stoc1);
				break;
			case 1:
				input = new Scanner(System.in);
				System.out.println("Enter store's name:");
				String storeName = input.next();
				System.out.println("Enter fiscalIdentifier:");
				String fiscalIdentifier= input.next();
				store1.addNewCashRegister(storeName, fiscalIdentifier);
				break;
			case 2:
				input = new Scanner(System.in);
				System.out.println("Enter store's name:");
				storeName = input.next();
				System.out.println("Enter fiscalIdentifier:");
				fiscalIdentifier= input.next();
				store1.removeCashRegister(storeName, fiscalIdentifier);
				break;
			case 3:
				System.out.println("Cash Registers: " + store1.returnCashRegisters());
				break;
			}
		}catch (NumberFormatException f) {}
		    }while(true);
	}
	
	public static void seller(Store store1,Stock stoc1)
	{
		do {
			System.out.println("\nChoose an option:");
		    System.out.println("0 - Back");
		    System.out.println("1 - Start Sell.");
		    System.out.println("2 - Search product.");   
		    System.out.println("3 - View Stock.");
		   
		try {
			input = new Scanner(System.in);
			int optiune = input.nextInt();
            
			switch(optiune)
			{
			case 0:
				mainMenu(store1,stoc1);
				break;
			case 1:
				input = new Scanner(System.in);
				System.out.println("Enter cashRegisters's index:");
				int index = input.nextInt();
				store1.getCashRegister(index).startNewSell();	
				sellerSell(store1,stoc1, index);				
				break;
			case 2:
				input = new Scanner(System.in);
				System.out.println("Enter product's name:");
				String removedProduct = input.next();
				System.out.println("Stoc " + store1.getSeller(0).checkProductsStock(store1.getStock().search(removedProduct)));
				break;
			case 3:
				System.out.println("The stock is: " + store1.getSeller(0).viewStock(stoc1));
				break;
			}
		}catch (NumberFormatException f) {}
		    }while(true);
	}
	
	public static void sellerSell(Store store1,Stock stoc1, int index)
	{
		do {
			System.out.println("Choose an option:");
		    System.out.println("0 - Back");
		    System.out.println("1 - Add product to sell.");
		    System.out.println("2 - Remove product.");   
		    System.out.println("3 - View current sell.");
		    System.out.println("4. Finalize sell.");
		try {
			input = new Scanner(System.in);
			int option = input.nextInt();
            
			switch(option)
			{
			case 0:
				seller(store1,stoc1);
				break;
			case 1:
				input = new Scanner(System.in);
				System.out.println("Enter product's name:");
				String productName = input.next();
				System.out.println("Enter quantity:");
				int  quantity = input.nextInt();
				System.out.println("Enter Currency:");
				String currency = input.next();
				store1.getSeller(0).sell(store1.getStock().search(productName), quantity, currency, store1.getCashRegister(index));
				break;
			case 2:
				input = new Scanner(System.in);
				System.out.println("Enter product's name:");
				productName = input.next();
				store1.getSeller(0).returnProducts(store1.getStock().search(productName),store1.getCashRegister(index));
				break;
			case 3:
				System.out.println("Current sell\n" + store1.getCashRegister(index).finalizeSell().returnReceiptItems().toString());
				break;
            case 4:
            	System.out.println("Receipt  " + store1.getCashRegister(index).finalizeSell().returnReceiptItems().toString()+ "\nTotal: " + store1.getCashRegister(0).finalizeSell().getTotal(stoc1) + " " + store1.getCashRegister(0).getCurrency(0));
				break;
			}
		}catch (NumberFormatException f) {}
		    }while(true);
	}
	
	public static void main(String[] args)
	{
		Stock stoc1 = new Stock();
		Store store1 = new Store("Etic","fashion", stoc1);
		store1.addNewAdministrator("Victor", "0733028119", "Str. Viscan");
		store1.addNewSeller("Iza", "0733253567","Str. Albinelor, Slatina");
		store1.addNewCashRegister("Etic", "Iza");
		
		mainMenu(store1,stoc1);
		}
}

