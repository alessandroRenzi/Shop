package report;

public class MinVisitor extends ExtremeVisitor {
	@Override
	public <E extends Comparable<E>> boolean evaluate(E result, E currentItem) {
		boolean check = false;

		if(result.compareTo(currentItem) == -1) {
			check = true;
		}
		return check;
	}
}
