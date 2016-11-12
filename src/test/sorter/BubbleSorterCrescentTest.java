package test.sorter;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sorter.BubbleSortCrescent;

public class BubbleSorterCrescentTest {
	List<Integer> toSort;
	List<Integer> sorted;

	@Before
	public void setUp(){
		this.toSort = new LinkedList<Integer>();
		this.toSort.add(10);
		this.toSort.add(5);
		this.toSort.add(2);
		
		this.sorted = new LinkedList<Integer>();
		this.sorted.add(2);
		this.sorted.add(5);
		this.sorted.add(10);
	}

	@Test
	public void testSortCrescent() {
		sorting();
		assertArrayEquals(this.sorted.toArray(),this.toSort.toArray());
	}

	private void sorting() {
		BubbleSortCrescent<Integer> temp = new BubbleSortCrescent<Integer>();
		temp.sort(this.toSort);
	}
}
