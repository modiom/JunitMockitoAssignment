import java.util.List;

public class Person {
	private penService penService;
	private List<penClass> pens;
	
	public int getPenPrice(List<penClass> pens){
	      int totalPrice = 0;
	      
	      for(penClass p:pens){
	         totalPrice += penService.getPrice(p);
	      }
	      return totalPrice;
	}
	
	public penService getPenService() {
		return penService;
	}
	public void setPenService(penService penService) {
		this.penService = penService;
	}
	public List<penClass> getPens() {
		return pens;
	}
	public void setPens(List<penClass> pens) {
		this.pens = pens;
	}
	
}
