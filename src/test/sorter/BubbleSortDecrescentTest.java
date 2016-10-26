package test.sorter;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sorter.BubbleSortDecrescent;

public class BubbleSortDecrescentTest {
	List<Integer> sorted;
	List<Integer> toSort;

	@Before
	public void setUp(){
		this.sorted = new LinkedList<Integer>();
		this.sorted.add(10);
		this.sorted.add(5);
		this.sorted.add(2);
		
		this.toSort = new LinkedList<Integer>();
		this.toSort.add(10);
		this.toSort.add(2);
		this.toSort.add(5);
	}

	@Test
	public void testSortDecrescent() {
		sorting();
		assertArrayEquals(this.sorted.toArray(),this.toSort.toArray());
	}

	private void sorting() {
		BubbleSortDecrescent<Integer> temp = new BubbleSortDecrescent<Integer>();
		temp.sort(this.toSort);
	}
}
