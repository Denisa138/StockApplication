import java.util.HashMap;
import java.math.BigDecimal;
import java.util.Map;

public class Product{
    private String name;
    private Map<String,String> characteristics= new HashMap<String, String>(); 
    private String category;
    private BigDecimal price;
    private Stock stock = null;
    
    Product(String name)
    {
    	this.name = name;
    }
    
    Product(String n,String n1, String n2, String c, BigDecimal p, Stock stock1)
    {
    	this.name = n;
    	characteristics.put(n1, n2);
    	this.category = c;
    	this.price = p;
    	this.stock = stock1;
    }
    
    Stock getStock()
    {
    	return stock;
    }
    
    String getName()
    {
    	return name;
    }
    
    void setName(String n)
    {
    	name = n;
    }
    
    String getCategory()
    {
    	return category;
    }
    
    void setCategory(String c)
    {
    	category = c;
    }
    
    BigDecimal getPrice()
    {
    	return price;
    }
    
    void setPrice(BigDecimal p)
    {
    	price = p;
    }
}
