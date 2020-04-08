
public class EmployeeInfo {
   private String name;
   private String phoneNumber;
   private String adress;
   
   EmployeeInfo(String n, String p, String a)
   {
	   this.name = n;
	   this.phoneNumber = p;
	   this.adress = a;
   }
   
   String getName()
   {
	   return name;
   }
   
   void setName(String n)
   {
	   this.name = n;
   }
   
   String getPhoneNumber()
   {
	   return phoneNumber;
   }
   
   void setPhoneNumber(String n)
   {
	   this.phoneNumber = n;
   }
   
   String getAdress()
   {
	   return adress;
   }
   
   void setAdress(String n)
   {
	   this.adress = n;
   }
}
