import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class priceable {
	public abstract int getPrice();
}

public class Box<T extends priceable> implements Comparable<Box>{
	
	List <T> items = new ArrayList<>();
	
	public Box(List<T> items) {
		super();
		this.items = items;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public void addItems(T t) {
		this.items.add(t);
	}
	
	public int getTotal(List<T> t) {
		return t.stream().mapToInt(T::getPrice).sum();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pen p1 = new pen("blue", 10);
		pen p2 = new pen("red", 4);
		pen p3 = new pen("black", 15);
		List<pen> penlist1 = new ArrayList<pen>();
		penlist1.add(p1);
		penlist1.add(p2);
		penlist1.add(p3);
		Box<pen> b1 = new Box<pen>(penlist1);
		System.out.println("Box b1 ");
		for(pen p : b1.items) {
			System.out.println(p.toString());
		}
		
		pen p4 = new pen("blue", 10);
		pen p5 = new pen("red", 4);
		pen p6 = new pen("black", 15);
		List<pen> penlist2 = new ArrayList<pen>();
		penlist2.add(p4);
		penlist2.add(p5);
		penlist2.add(p6);
		Box<pen> b2 = new Box<pen>(penlist2);
		System.out.println("Box b2 ");
		for(pen p : b2.items) {
			System.out.println(p.toString());
		}
		System.out.println("calling the equals method b1.equals(b2)  --> " + b1.equals(b2));
		System.out.println("calling the compareTo method b1.compareTo(b2) --> " + b1.compareTo(b2));
		System.out.println("Adding new item to b2");
		b2.addItems(new pen("green", 30));
		for(pen p : b2.items) {
			System.out.println(p.toString());
		}
		System.out.println("calling the equals method b1.equals(b2) after adding item  --> " + b1.equals(b2));
		System.out.println("calling the compareTo method b1.compareTo(b2) after adding item  --> " + b1.compareTo(b2));
	}

	@Override
	public int compareTo(Box o) {
		// TODO Auto-generated method stub
		Integer sum1 = (Integer)this.getTotal(this.getItems());
		Integer sum2 = (Integer)o.getTotal(o.getItems());
		System.out.println("Total price of box b1 "+sum1 + "  and for box b2 is " + sum2);
		return sum1.compareTo(sum2);
	}
	
		
	}

class pen extends priceable{
	
	private String color;
	private int price;
	public pen(String color, int price) {
		super();
		this.color = color;
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + price;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pen other = (pen) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "pen [color=" + color + ", price=" + price + "]";
	}
	
	
	
	
	
}
