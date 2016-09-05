package test.sorter;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sorter.BubbleSortCrescent;

public class BubbleSorterCrescentTest {
	List<Integer> toSort;
	List<Integer> Sorted;

	@Before
	public void setUp(){
		toSort = new LinkedList<Integer>();
		Sorted = new LinkedList<Integer>();
		toSort.add(10);
		toSort.add(5);
		toSort.add(2);
		Sorted.add(2);
		Sorted.add(5);
		Sorted.add(10);
	}

	@Test
	public void sortCrescentTest() {
		sorting();
		assertArrayEquals(Sorted.toArray(),toSort.toArray());
	}

	private void sorting() {
		BubbleSortCrescent<Integer> temp = new BubbleSortCrescent<Integer>();
		temp.sort(toSort);
	}
}
