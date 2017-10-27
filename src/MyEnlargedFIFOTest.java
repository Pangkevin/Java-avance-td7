import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class MyEnlargedFIFOTest {

	 @Test(expected=IllegalArgumentException.class)
	  public void testFifoCapacity() {
	    new MyEnlargedFIFO<String>(-3);
	  }
	  
	  @Test(expected=IllegalArgumentException.class)
	  public void testFifoCapacity2() {
	    new MyEnlargedFIFO<Integer>(0);
	  }

  
	  @Test
	  public void testPlenty() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    for(int i=0; i<100000; i++) {
	      assertTrue(fifo.offer(i));
	    }
	  }

	  @Test
	  public void testContract() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    for(int i=0; i<10000; i++) {
	      fifo.offer(i);
	    }
	    for(int i=0; i<10000; i++) {
	      assertEquals(i, (int)fifo.poll());
	    }
	  }

	  @Test
	  public void testSize() {
	    MyEnlargedFIFO<String> fifo = new MyEnlargedFIFO<>(1);
	    for(int i=0; i<10000; i++) {
	      assertEquals(i, fifo.size());
	      fifo.offer("bli");
	    }
	  }
	  
	  @Test
	  public void testIsEmpty() {
	    MyEnlargedFIFO<String> fifo = new MyEnlargedFIFO<>(1);
	    assertTrue(fifo.isEmpty());
	    fifo.offer("rien");
	    assertFalse(fifo.isEmpty());
	    fifo.offer("af");
	    assertFalse(fifo.isEmpty());
	    fifo.poll();
	    fifo.poll();
	    assertTrue(fifo.isEmpty());
	  }
	  
	  public void testPeek() {
	    MyEnlargedFIFO<String> fifo = new MyEnlargedFIFO<>(1);
	    assertNull(fifo.peek());
	  }
	  
	  @Test
	  public void testPeek2() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    fifo.offer(1);
	    assertEquals(1, (int)fifo.peek());
	    fifo.poll();
	    fifo.offer(2);
	    fifo.offer(3);
	    assertEquals(2, (int)fifo.peek());
	    fifo.poll();
	    assertEquals(3, (int)fifo.peek());
	  }
	  
	  @Test(expected=NoSuchElementException.class)
	  public void testElement() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    fifo.element();
	  }
	  
	  @Test
	  public void testIterator() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    for(int i=0; i<10000; i++) {
	      fifo.offer(i);
	    }
	    int i = 0; 
	    for(int value: fifo) {
	      assertEquals(i++, value);
	    }
	    assertEquals(10000, fifo.size());
	  }
	  
	  @Test
	  public void testIterator2() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    fifo.offer(1);
	    fifo.poll();
	    
	    for(int i=0; i<100; i++) {
	      fifo.offer(i);
	    }
	    int i = 0; 
	    for(int value: fifo) {
	      assertEquals(i++, value);
	    }
	    assertEquals(100, fifo.size());
	  }
	  
	  @Test(expected=UnsupportedOperationException.class)
	  public void testIteratorRemove() {
	    MyEnlargedFIFO<String> fifo = new MyEnlargedFIFO<>(1);
	    fifo.offer("blaaaa");
	    fifo.iterator().remove();
	  }
	  
	  @Test
	  public void testToString() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    for(int i=0; i<77; i++) {
	      fifo.offer(i);
	    }
	    
	    StringBuilder builder = new StringBuilder().append('[');
	    for(Iterator<Integer> it = fifo.iterator(); it.hasNext();) {
	      builder.append(it.next());
	      if (it.hasNext()) {
	        builder.append(", ");
	      }
	    }
	    String text = builder.append(']').toString();
	    
	    assertEquals(text, fifo.toString());
	  }
	  
	  @Test
	  public void testAddAll() {
	    MyEnlargedFIFO<Integer> fifo = new MyEnlargedFIFO<>(1);
	    for(int i=0; i<3; i++) {
	      fifo.offer(i);
	    }
	    
	    MyEnlargedFIFO<Object> fifo2 = new MyEnlargedFIFO<>(1);
	    fifo2.addAll(fifo);
	    
	    assertEquals(fifo2.size(), fifo.size());
	    
	    Iterator<Object> it2 = fifo2.iterator();
	    Iterator<Integer> it = fifo.iterator();
	    while(it2.hasNext()) {
	      assertTrue(it.hasNext());
	      assertEquals(it2.next(), it.next());
	    }
	  }

}
