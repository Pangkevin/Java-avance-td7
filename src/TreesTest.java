package tds.td7.fifo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TreesTest {

	@Test
	public void testOrder() {
		Tree t = new Tree(0,new Tree(1, new Tree(3), new Tree(4)), new Tree(2, new Tree(5), new Tree(6)));
		List<Tree> ll = Trees.bfs(t);
		int i = 0;
		for(Tree tree:ll) {
			assertEquals(i++, tree.getId());
		}
	}
	
	@Test
	public void testOrder2() {
		Tree t = new Tree(0,new Tree(1,new Tree(3), new Tree(4)), new Tree(2));
		List<Tree> ll = Trees.bfs(t);
		int i = 0;
		for(Tree tree:ll) {
			assertEquals(i++, tree.getId());
		}
	}
	
	@Test
	public void testOrder3() {
		Tree t = new Tree(0, new Tree(1), new Tree(2, new Tree(3), new Tree(4)));
		List<Tree> ll = Trees.bfs(t);
		int i = 0;
		for(Tree tree:ll) {
			assertEquals(i++, tree.getId());
		}
	}
	
	@Test
	public void testOrder4() {
		Tree t = new Tree(0,new Tree(1, new Tree(3), new Tree(4, new Tree(7, new Tree(9), new Tree(10)), null)  ), new Tree(2, new Tree(5, new Tree(8), null), new Tree(6)));
		List<Tree> ll = Trees.bfs(t);
		int i = 0;
		for(Tree tree:ll) {
			assertEquals(i++, tree.getId());
		}
	}
	
	
}
