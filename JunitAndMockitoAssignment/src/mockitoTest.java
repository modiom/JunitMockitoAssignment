import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

public class mockitoTest {

	   static Person person;	
	   static penService penService;
		   
	   
	   public static void main(String[] args){
	      
	      mockitoTest.setUp();
	      System.out.println(mockitoTest.mockPenPrice()?"successful":"failure");
	   }
	   
	   public static void setUp(){
	      //Create a person object which is to be tested		
	      person = new Person();		
	  
	      //Create the mock object of pen service
	      penService = Mockito.mock(penService.class);		
	  
	      //set the penService to the person
	      person.setPenService(penService);
	   }
	   
	   public static boolean mockPenPrice(){
	    	   
	      //Create a list of pens to be bought by person
	      List<penClass> pens = new ArrayList<penClass>();
	      penClass p1 = new penClass("red","gel");
		  penClass p2 = new penClass("blue","ball");
		  penClass p3 = new penClass("black","Ink");
	 
	      pens.add(p1);
	      pens.add(p2);
	      pens.add(p3);

	      //add pen to the person
	      person.setPens(pens);

	      //mock the behavior of service to return the price of pens
	      Mockito.when(penService.getPrice(p1)).thenReturn(20);
	      Mockito.when(penService.getPrice(p2)).thenReturn(10);
	      Mockito.when(penService.getPrice(p3)).thenReturn(50);		

	                   
	      int pensPrice = person.getPenPrice(pens);		
	      return pensPrice == 80;
	   }

}
