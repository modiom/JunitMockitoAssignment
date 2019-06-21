import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoxJunit {
	
	pen p1;
	pen p2;
	pen p3;
	List<pen> penlist1 = new ArrayList<pen>();
	List<pen> penlist2 = new ArrayList<pen>();
	Box<pen> b1;
	Box<pen> b2;
	@Before
	public  void setUpBeforeClass() throws Exception {
		p1 = new pen("blue", 10);
		p2 = new pen("red", 4);
		p3 = new pen("black", 15);
		penlist1.add(p1);
		penlist1.add(p2);
		penlist1.add(p3);
		b1 = new Box<pen>(penlist1);
		
		
		  penlist2.add(p1); penlist2.add(p2); penlist2.add(p3);
		 
		b2 = new Box<pen>(penlist2);
		System.out.println("@Before Annotation excecuted");
		
	}

	@Test
	public void checkTotalPrice() {
		assertEquals(29, b1.getTotal(b1.getItems()));
		
		assertEquals(29, b2.getTotal(b2.getItems()));
		
	}
	@Test
	public void checkBagCompare() {
		assertEquals(0,b1.compareTo(b2));
		b2.addItems(new pen ("orange",10));
		assertEquals(-1,b1.compareTo(b2));
		
	}
	@After
	public  void tearDownAfterClass() throws Exception {
		System.out.println("@After Annotation called!");
	}

}
