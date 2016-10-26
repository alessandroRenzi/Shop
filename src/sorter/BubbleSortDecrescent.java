package sorter;

public class BubbleSortDecrescent<E extends Comparable<E>> extends BubbleSorter<E> {
	
	public BubbleSortDecrescent(){
		super();
	}
	
	@Override
	protected boolean outOfOrder(int j) {
			boolean result = false;
			
			E current = super.getElement(j);
			E toCompare = super.getElement(j-1);
			
			if(toCompare.compareTo(current) < 0) {
				result = true;
			}
			return result;
	}

	@Override
	protected void swap(int j) {
		E temp = super.getElement(j-1);
		super.setElement(j-1, super.getElement(j));
		super.setElement(j, temp);
	}
}
