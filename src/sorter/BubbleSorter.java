package sorter;

import java.util.List;

public abstract class BubbleSorter<E extends Comparable<E>> implements Sorter<E> {
	private List<E> toSort;

	public BubbleSorter() {
		super();
	}
	
	public E getElement(int index){
		return this.toSort.get(index);
	}
	
	public void setElement(int index, E element){
		this.toSort.set(index,element);
	}
	
	public final void sort(List<E> toSort) {
		this.toSort = toSort;
		int limit = this.toSort.size();
		
		for(int i = limit-1; i > 0; i--) {
			for(int j = i; j < limit; j++) {
				if(outOfOrder(j)) {
					swap(j);
				}
			}
		}
	}
	
	protected abstract boolean outOfOrder(int j);
	protected abstract void swap(int j);
}
