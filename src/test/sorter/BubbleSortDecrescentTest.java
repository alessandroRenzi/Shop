package test.sorter;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sorter.BubbleSortDecrescent;

public class BubbleSortDecrescentTest {
	List<Integer> toSort;
	List<Integer> Sorted;

	@Before
	public void setUp(){
		toSort = new LinkedList<Integer>();
		Sorted = new LinkedList<Integer>();
		toSort.add(10);
		toSort.add(2);
		toSort.add(5);
		Sorted.add(10);
		Sorted.add(5);
		Sorted.add(2);
	}

	@Test
	public void sortCrescentTest() {
		sorting();
		assertArrayEquals(Sorted.toArray(),toSort.toArray());
	}

	private void sorting() {
		BubbleSortDecrescent<Integer> temp = new BubbleSortDecrescent<Integer>();
		temp.sort(toSort);
	}
}
