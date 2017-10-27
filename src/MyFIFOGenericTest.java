import static org.junit.Assert.*;

import org.junit.Test;

public class MyFIFOGenericTest {

	  @Test
	  public void testOfferPollOneElement() {
	    MyFIFO<String> fifo = new MyFIFO<>(3);
	    fifo.offer("univ");
	    String s = fifo.poll();
	    assertEquals("univ", s);
	  }
	  
	  @Test
	  public void testOfferPoll() {
	    MyFIFO<Integer> fifo = new MyFIFO<>(2);
	    fifo.offer(1);
	    assertEquals(1, (int)fifo.poll());
	    fifo.offer(2);
	    fifo.offer(3);
	    assertEquals(2, (int)fifo.poll());
	    fifo.offer(4);
	    assertEquals(3, (int)fifo.poll());
	    assertEquals(4, (int)fifo.poll());
	  }
	  
	  @Test
	  public void testFullToEmpty() {
	    MyFIFO<Object> fifo = new MyFIFO<>(20);
	    for(int i = 0; i < 20; i++) {
	      fifo.offer(i);
	    }
	    assertEquals(0, (int)fifo.poll());
	    fifo.offer("sqs");
	    for(int i = 1; i < 20; i++) {
	      assertEquals(i, (int)fifo.poll());
	    }
	    assertEquals("sqs", fifo.poll());
	  }

}
