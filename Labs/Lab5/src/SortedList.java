public class SortedList extends IntegerList {

	public SortedList() {
		super();
	}
	
	public SortedList(int capacity) {
		super(capacity);
	}
	
	public void add(int integer) {
		int index = super.size();
		for(int i = 0; i < super.size(); i++) {
			int currentInt = super.get(i);
			if (currentInt > integer) {
				index = i;
				break;
			}
		}
		super.insert(index, integer);
	}
	
	public void insert(int index, int integer) {
		throw new UnsupportedOperationException();
	}
	
}
