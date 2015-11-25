package sorter;

import java.util.List;

public interface Sorter<E extends Comparable<E>> {
	public void sort(List<E> toSort);
}
