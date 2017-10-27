import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MyFIFOTest {

	 @Test(expected=IllegalArgumentException.class)
	  public void testMyFIFOCapacity() {
	    new MyFIFO(-3);
	  }
	  
	  @Test(expected=IllegalArgumentException.class)
	  public void testMyFIFOCapacity2() {
	    new MyFIFO(0);
	  }

	  @Test(expected=IllegalStateException.class)
	  public void testEmpty() {
	    MyFIFO fifo = new MyFIFO(1);
	    fifo.poll();
	  }
	  
	  @Test(expected=IllegalStateException.class)
	  public void testFull() {
	    MyFIFO fifo = new MyFIFO(1);
	    fifo.offer(16);
	    fifo.offer(64);
	  }

	  @Test(expected=NullPointerException.class)
	  public void testOfferNull() {
	    MyFIFO fifo = new MyFIFO(42);
	    fifo.offer(null);
	  }
	  
	  
	  
	  @Test
	  public void testOfferPoll() {
	    MyFIFO fifo = new MyFIFO(2);
	    fifo.offer(3);
	    assertEquals(3, fifo.poll());
	    fifo.offer(4);
	    fifo.offer(5);
	    assertEquals(4, fifo.poll());
	    fifo.offer(6);
	    assertEquals(5, fifo.poll());
	    assertEquals(6, fifo.poll());
	  }
	  
	  @Test
	  public void testFullToEmpty() {
	    MyFIFO fifo = new MyFIFO(20);
	    for(int i = 0; i < 20; i++) {
	      fifo.offer(i);
	    }
	    assertEquals(0, fifo.poll());
	    fifo.offer("bli");
	    for(int i = 1; i < 20; i++) {
	      assertEquals(i, fifo.poll());
	    }
	    assertEquals("bli", fifo.poll());
	  }

	  @Test
	  public void testSize() {
	    MyFIFO fifo = new MyFIFO(2);
	    assertEquals(0, fifo.size());
	    fifo.offer(16);
	    assertEquals(1, fifo.size());
	    fifo.offer(64);
	    assertEquals(2, fifo.size());
	    fifo.poll();
	    assertEquals(1, fifo.size());
	    fifo.poll();
	    assertEquals(0, fifo.size());
	  }
	  
	  @Test
	  public void testSizeEmpty() {
	    MyFIFO fifo = new MyFIFO(1);
	    assertEquals(0, fifo.size());
	  }
	  
	  @Test
	  public void testSizeFull() {
	    MyFIFO fifo = new MyFIFO(1);
	    fifo.offer("dauphine");
	    assertEquals(1, fifo.size());
	  }
	  
	  @Test
	  public void testIsEmpty() {
	    MyFIFO fifo = new MyFIFO(2);
	    assertTrue(fifo.isEmpty());
	    fifo.offer("aa");
	    assertFalse(fifo.isEmpty());
	    fifo.offer("zz");
	    assertFalse(fifo.isEmpty());
	    fifo.poll();
	    fifo.poll();
	    assertTrue(fifo.isEmpty());
	  }
	  
	  @Test
	  public void testEmptyToString() {
	    MyFIFO fifo = new MyFIFO(23);
	    assertEquals("[]", fifo.toString());
	  }
	  
	  @Test
	  public void testOneElementToString() {
	    MyFIFO fifo = new MyFIFO(42);
	    fifo.offer("lolo");
	    assertEquals("[lolo]", fifo.toString());
	  }
	  
	  @Test
	  public void testTwoElementToString() {
	    MyFIFO fifo = new MyFIFO(42);
	    fifo.offer("chi");
	    fifo.offer("mon");
	    assertEquals("[chi, mon]", fifo.toString());
	  }
	  
	  @Test
	  public void testNonMutateToString() {
	    MyFIFO fifo = new MyFIFO(150);
	    ArrayList<Integer> list = new ArrayList<>();
	    for(int i = 0; i < 100; i++) {
	      fifo.offer(i);
	      list.add(i);
	    }
	    assertEquals(list.toString(), fifo.toString());
	    for(int i = 0; i < 100; i++) {
	      assertEquals(i, fifo.poll());
	    }
	  }
	  
	  @Test
	  public void testFullToString() {
	    MyFIFO fifo = new MyFIFO(99);
	    ArrayList<Integer> list = new ArrayList<>();
	    for(int i = 0; i < 99; i++) {
	      fifo.offer(i);
	      list.add(i);
	    }
	    assertEquals(list.toString(), fifo.toString());
	  }
}
